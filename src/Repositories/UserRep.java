package Repositories;

import dto.DbConFig;
import models.Answer;
import models.User;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class UserRep {

    public User checkUser(String tryEmail, String tryPassword) {
        String sql = "select*from users where  email = ? and password = ?";
        User user = null;
        Connection connection = DbConFig.conn;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, tryEmail);
            statement.setString(2, tryPassword);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String user_group = rs.getString("user_group");
                user = new User(email, password, user_group, id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public ArrayList<Answer> getAnswers(int user_id) {
        String sql = "select*from answers where user_id =? order by id desc limit 5";
        ArrayList<Answer> answers = new ArrayList<>();
        Connection connection = DbConFig.conn;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, user_id);
            ResultSet rs = stmt.executeQuery();
            Answer answerObj = null;

            while (rs.next()) {
                int id = rs.getInt("id");
                String answer = rs.getString("answer");
                String phone_number = rs.getString("phone_number");
                String request_number = rs.getString("request_number");
                String latitude = rs.getString("latitude");
                String longitude = rs.getString("longitude");
                Date date = rs.getDate("date_answer");
                answerObj = new Answer(phone_number, request_number, answer, latitude, user_id, longitude, id, date);
                answers.add(answerObj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return answers;

    }

    public void deleteAnswer(int id) {
        String sql = "delete from answers where id = ?";
        Connection connection = DbConFig.conn;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void addAnswer(Answer answerObj, int id) {
        String sql = "insert into answers(request_number,phone_number,answer,user_id,latitude,longitude,date_answer) select ?,?,?,?,?,?,?  from users where id = (?)";
        Connection connection = DbConFig.conn;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, answerObj.getRequest_number());
            stmt.setString(2, answerObj.getPhone_number());
            stmt.setString(3, answerObj.getAnswer_type());
            stmt.setInt(4, answerObj.getUser_id());
            stmt.setString(5, answerObj.getLatitude());
            stmt.setString(6, answerObj.getLongitude());
            stmt.setDate(7, answerObj.getDateAnsw());
            stmt.setInt(8, id);

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void addAnswerDB(String req_num, String soluion, Date end_time, Date answer_time, String bts_name,
                            String coordinate, String user_number, String area, String login, String user_group, String complain_type, String latitude,
                            String longitude, String repeated
    ) {
        String sql = "insert into web_sc_db(request_number, solution_type, end_time, answer_time, " +
                "bts_name, coordinate, user_number, area_city, login, user_group,complain_type,latitude,longitude,repeated) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection connection = DbConFig.conn;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, req_num);
            stmt.setString(2, soluion);
            stmt.setDate(3, end_time);
            stmt.setDate(4, answer_time);
            stmt.setString(5, bts_name);
            stmt.setString(6, coordinate);
            stmt.setString(7, user_number);
            stmt.setString(8, area);
            stmt.setString(9, login);
            stmt.setString(10, user_group);
            stmt.setString(11, complain_type);
            stmt.setString(12,latitude);
            stmt.setString(13,longitude);
            stmt.setString(14,repeated);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addUser(String email, String password, String group) {
        String sql = "insert into users(email,password,user_group) VALUES (?,?,?)";
        Connection connection = DbConFig.conn;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, password);
            stmt.setString(3, group);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public void deleteuser(int id) {
//        String sql = "delete from users where id = ?";
//        Connection connection = DbConFig.conn;
//        try {
//            PreparedStatement stmt = connection.prepareStatement(sql);
//            stmt.setInt(1, id);
//            stmt.execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public User checkUserByGroupAndStatus (String email, String password) throws Exception {

        User user_from_Active_Directory;
//        UserRep userRep = new UserRep();

        Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        props.put(Context.PROVIDER_URL, "ldap://1.2.3.4:389");
        props.put(Context.SECURITY_PRINCIPAL, "CN=grafana,OU=Service_Accounts,OU=TELE2,DC=JV,DC=MT-S,DC=KZ"); //adminuser - User with special priviledge, dn user
        props.put(Context.SECURITY_CREDENTIALS, "v3fru+RafrA6");//dn user password
        InitialDirContext context = new InitialDirContext(props);
        SearchControls ctrls = new SearchControls();
        ctrls.setReturningAttributes(new String[]{"givenName", "sn", "memberOf"});
        ctrls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        NamingEnumeration<SearchResult> answers = context.search("OU=Users,OU=TELE2,DC=JV,DC=MT-S,DC=KZ", "(&(memberOf=CN=wsc_users,OU=Group,OU=TELE2,DC=JV,DC=MT-S,DC=KZ)(sAMAccountName="+ email +"))", ctrls);

        if(!answers.hasMore()){
            return null;
        }

        SearchResult result = answers.nextElement();
        String user = result.getNameInNamespace();

        try {
            props = new Properties();
            props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            props.put(Context.PROVIDER_URL, "ldap://1.2.3.4:389");
            props.put(Context.SECURITY_PRINCIPAL, user);
            props.put(Context.SECURITY_CREDENTIALS, password);
            context = new InitialDirContext(props);
        } catch (Exception e) {

            return null;
        }

        boolean user_group_E2E = result.toString().contains("CN=Performance_Quality_E2E_KZ");
        boolean user_group_Back = result.toString().contains("CN=BackOffice_KZ");
        boolean user_group_NOC = result.toString().contains("CN=NOC_RW");

        String group = null;

        if(user_group_E2E == true){
            group = "performance";
        }else if(user_group_Back == true){
            group = "backoffice";
        }else if (user_group_NOC == true)
            group = "nomhelpdesk";

       // int id = userRep.checkUser(username).getId();

        //if(userRep.checkUser(username) == null)
         //   userRep.addUser(username, password, group);

//группу указывает верно
        user_from_Active_Directory = new User(email, password, group);

        context.close();

        return user_from_Active_Directory;
    }
}
