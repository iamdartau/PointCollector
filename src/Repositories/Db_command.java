package Repositories;

import dto.DbConFig;
import models.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Db_command {

    public String checkCell(Set<Cell> cells, String table, String service) {
        String sql = "select * FROM " + service + table + " where cell = (?)";

        Connection connection = DbConFig.conn;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            for (Cell c : cells) {
                String formatted = checkFormatCell(c.getCell_id());
                stmt.setString(1, formatted);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    return formatted;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<String> getTransport() {

        String sql = "select * FROM transmission";
        ArrayList<String> transportSites = new ArrayList<>();
        Connection connection = DbConFig.conn;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String site_name = rs.getString("site_name");
                transportSites.add(site_name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transportSites;
    }

    public ArrayList<String> getNearSolutions(String bd, double latitude, double longitude) {
        String sql = "SELECT Site_name,\n" +
                "( 6371 * \n" +
                "    ACOS( \n" +
                "        COS( RADIANS( LATITUDE ) ) * \n" +
                "        COS( RADIANS( " + latitude + " ) ) * \n" +
                "        COS( RADIANS( " + longitude + " ) - \n" +
                "        RADIANS( LONGITUDE ) ) + \n" +
                "        SIN( RADIANS( LATITUDE ) ) * \n" +
                "        SIN( RADIANS( " + latitude + ") ) \n" +
                "    ) \n" +
                ") \n" +
                "AS distance FROM " + bd + " HAVING distance <= 1 ORDER BY distance ASC";

        ArrayList<String> nearSolutions = new ArrayList<>();
        Connection connection = DbConFig.conn;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("site_name");
                nearSolutions.add(name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nearSolutions;
    }

    public String checkHardware(Set<Cell> cells, String table) {
        String sql = "select * FROM " + table + " where sector = (?)";

        Connection connection = DbConFig.conn;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            for (Cell c : cells) {
                String formatted = checkFormat(c.getCell_id());
                stmt.setString(1, formatted);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    return formatted;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public ArrayList<Alarms> getAlarms() {
        String sql = "SELECT * FROM alarms";
        ArrayList<Alarms> alarms_list = new ArrayList<>();
        Connection connection = DbConFig.conn;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            Alarms alarm = null;
            while (rs.next()) {
//                System.out.println(rs.getString("BTS_name"));
                int id = rs.getInt("idalarms");
                String bs_name = rs.getString("BTS_name");
                String alarm_name = rs.getString("Alarm_name");
                alarm = new Alarms(bs_name, alarm_name, id);
                alarms_list.add(alarm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alarms_list;
    }
    /*
        public Transport_detail getTransDetail (Set<String> bts_string_set){
            String sql = "select * from ISKA.transport_detail where site_name = ?";

            String bs_name = bts_string_set.toString();
            Checker checker = new Checker();
            String formd_bs_name = checker.CheckBsFormat(bs_name);

            Connection connection = DbConFig.conn;
            PreparedStatement statement = null;
            ResultSet rs = null;
            Transport_detail transport_detail = null;

            try{
                statement = connection.prepareStatement(sql);
                statement.setString(1, formd_bs_name);
                rs = statement.executeQuery();
                while (rs.next()){
                    String site_name = rs.getString("site_name");
                    String comment = rs.getString("comment");
                    transport_detail = new Transport_detail(site_name, comment);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return transport_detail;
        }
    */

    //todo методы дублируются, просто добавь в аргументы имя таблицы, и сделай фабрику для сущностей

    public MocnOptimization getMocnOptimization (Set<String> bts_string_set) {
        String sql = "select * from ISKA.mocn where site = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        MocnOptimization mocnOptimization = null;
        try {
            connection = DbConFig.conn;
            for (String bs : bts_string_set) {
                statement = connection.prepareStatement(sql);
                statement.setString(1, bs);
                rs = statement.executeQuery();
                while (rs.next()) {
                    String site = rs.getString("site");
                    String comment = rs.getString("comment");
                    mocnOptimization = new MocnOptimization(site, comment);

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mocnOptimization;
    }

    public Transport_detail getTransDetail (Set<String> bts_string_set) {
        String sql = "select * from ISKA.transport_detail where site_name = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        Transport_detail transport_detail = null;
        try {
            connection = DbConFig.conn;
            for (String bs : bts_string_set) {
                statement = connection.prepareStatement(sql);
                statement.setString(1, bs);
                rs = statement.executeQuery();
                while (rs.next()) {
                    String site_name = rs.getString("site_name");
                    String comment = rs.getString("comment");
                    transport_detail = new Transport_detail(site_name, comment);

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transport_detail;
    }

    public Set<String> getNearBS(Distance point, Connection connection, String Ntype, int radius) {
        Set<String> Bts_array = new HashSet<>();
        String sql = "SELECT NAME,\n" +
                "( 6371 * \n" +
                "    ACOS( \n" +
                "        COS( RADIANS( LATITUDE ) ) * \n" +
                "        COS( RADIANS( " + point.getLatitude() + " ) ) * \n" +
                "        COS( RADIANS( " + point.getLongitude() + " ) - \n" +
                "        RADIANS( LONGITUDE ) ) + \n" +
                "        SIN( RADIANS( LATITUDE ) ) * \n" +
                "        SIN( RADIANS( " + point.getLatitude() + ") ) \n" +
                "    ) \n" +
                ") \n" +
                "AS distance from sites inner join " + Ntype + "transmitters \n" +
                "on sites.NAME = " + Ntype + "transmitters.SITE_NAME where \n" +
                Ntype + "transmitters.Activated_BTS='On-Air' or " + Ntype + "transmitters.Activated_BTS='CDD'\n" +
                " HAVING distance < 1 ORDER BY distance ASC;\n";
//        String sql = "select NAME,LATITUDE,LONGITUDE from sites INNER join " + Ntype + "transmitters on sites.NAME = " + Ntype + "transmitters.SITE_NAME where " + Ntype + "transmitters.Activated_BTS='On-Air' or " + Ntype + "transmitters.Activated_BTS='CDD'";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String Name = rs.getString("NAME");
                Bts_array.add(Name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Bts_array;
    }


    public Answer near(String latitude, String longitude) {
        Answer answer = null;
        Connection connection = DbConFig.conn;
        String sql = "SELECT\n" +
                "    solution_type,end_time,request_number,bts_name,(\n" +
                "      6371 * acos (\n" +
                "      cos ( radians(" + latitude + ") )\n" +
                "      * cos( radians( latitude ) )\n" +
                "      * cos( radians( longitude ) - radians(" + longitude + ") )\n" +
                "      + sin ( radians(" + latitude + ") )\n" +
                "      * sin( radians( latitude ) )\n" +
                "    )\n" +
                ") AS distance\n" +
                "FROM web_sc_db HAVING distance < 0.05;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String complain = rs.getString("solution_type") ;
                Date date = rs.getDate("end_time");
                String request = rs.getString("request_number");
                String btsName = rs.getString("bts_name");
                answer = new Answer(request,complain, java.sql.Date.valueOf(date.toString()),btsName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
      return answer;
    }

    public Set<Cell> getNearCellsGsm(Set<String> nearBs, Connection connection) {
        String sql = "select NAME,TX_ID,AZIMUT,LATITUDE,LONGITUDE from sites inner join " +
                "gtransmitters on sites.Name=gtransmitters.SITE_NAME where NAME =(?)";
        Set<Cell> nearCells = new HashSet<>();
        for (String bs : nearBs) {
            try {
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1, bs);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    String Name = rs.getString("NAME");
                    String TX_ID = rs.getString("TX_ID");
                    int azimut = rs.getInt("AZIMUT");
                    double latitude = Double.parseDouble(rs.getString("LATITUDE"));
                    double longitude = Double.parseDouble(rs.getString("LONGITUDE"));

                    Pattern MY_PATTERN = Pattern.compile("[A-Z]{2,3}\\d{3,4}\\w\\d\\w-\\d");
                    Matcher m = MY_PATTERN.matcher(TX_ID);
                    List<String> listMatches = new ArrayList<String>();

                    while (m.find()) {
                        listMatches.add(m.group(0));
                    }

                    for (String s : listMatches) {
                        Cell cell = new Cell(Name, s, azimut, 0, latitude, longitude);
                        nearCells.add(cell);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return nearCells;
    }


    public Set<Cell> getNearCells(Set<String> nearBs, Connection connection, String cellType) {
        String sql = "select NAME,CELL_ID,AZIMUT,LATITUDE,LONGITUDE from sites inner join "
                + cellType + "transmitters on sites.NAME = " + cellType +
                "transmitters.SITE_NAME inner join " + cellType + "cells on " +
                cellType + "transmitters.TX_ID=+" + cellType + "cells.TX_ID where NAME = (?)";
        Set<Cell> nearCells = new HashSet<>();
        for (String bs : nearBs) {
            try {
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1, bs);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    String Name = rs.getString("NAME");
                    String Cell_id = rs.getString("CELL_ID");
                    int azimut = rs.getInt("AZIMUT");
                    double latitude = Double.parseDouble(rs.getString("LATITUDE"));
                    double longitude = Double.parseDouble(rs.getString("LONGITUDE"));

                    Pattern MY_PATTERN = Pattern.compile("[A-Z]{2,3}\\d{3,4}\\w\\d\\w-\\d");
                    Matcher m = MY_PATTERN.matcher(Cell_id);
                    List<String> listMatches = new ArrayList<String>();

                    while (m.find()) {
                        listMatches.add(m.group(0));
                    }

                    for (String s : listMatches) {
                        Cell cell = new Cell(Name, s, azimut, 0, latitude, longitude);
                        nearCells.add(cell);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return nearCells;
    }



    public ArrayList<User> getAllUsers() {
        String sql = "SELECT * FROM users where user_group = 'backoffice'";

        ArrayList<User> usersList = new ArrayList<>();
        Connection connection = DbConFig.conn;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            User user = null;
            while (rs.next()) {
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String password = rs.getString("password");
                user = new User(email, password, id);
                usersList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersList;
    }

    public ArrayList<User> getAllUsersNoc() {
        String sql = "SELECT * FROM users where user_group = 'nomhelpdesk'";

        ArrayList<User> usersList = new ArrayList<>();
        Connection connection = DbConFig.conn;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            User user = null;
            while (rs.next()) {
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String password = rs.getString("password");
                user = new User(email, password, id);
                usersList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersList;
    }

    public String checkFormat(String cell) {
        Pattern MY_PATTERN = Pattern.compile("[A-Z]{2,3}\\d{3,4}\\w");
        Matcher m = MY_PATTERN.matcher(cell);
        List<String> listMatches = new ArrayList<String>();
        String Formatted = "";

        while (m.find()) {
            listMatches.add(m.group(0));
        }

        for (String s : listMatches) {
            Formatted = s;
        }
        return Formatted;
    }

    public String checkFormatCell(String cell) {
        Pattern MY_PATTERN = Pattern.compile("[A-Z]{2,3}\\d{3,4}\\w\\d\\w");
        Matcher m = MY_PATTERN.matcher(cell);
        List<String> listMatches = new ArrayList<String>();
        String Formatted = "";

        while (m.find()) {
            listMatches.add(m.group(0));
        }

        for (String s : listMatches) {
            Formatted = s;
        }
        return Formatted;
    }




}
