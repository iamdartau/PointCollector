package models;

import java.sql.Date;

public class Answer {
    private String phone_number;
    private String request_number;
    private String answer_type;
    private String latitude;
    private int user_id;
    private String longitude;
    private Date dateAnsw;

    public Date getDateAnsw() {
        return dateAnsw;
    }

    public void setDateAnsw(Date dateAnsw) {
        this.dateAnsw = dateAnsw;
    }

    public Answer(String request_number, String answer_type, Date dateAnsw, String latitude) {
        this.request_number = request_number;
        this.answer_type = answer_type;
        this.dateAnsw = dateAnsw;
        this.latitude = latitude;
    }

    public Answer(String phone_number, String request_number, String answer_type, String latitude, int user_id, String longitude, int id, Date dateAnsw) {
        this.phone_number = phone_number;
        this.request_number = request_number;
        this.answer_type = answer_type;
        this.latitude = latitude;
        this.user_id = user_id;
        this.longitude = longitude;
        this.id = id;
        this.dateAnsw= dateAnsw;
    }

    public int getUser_id() {

        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPhone_number() {

        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getRequest_number() {
        return request_number;
    }

    public void setRequest_number(String request_number) {
        this.request_number = request_number;
    }

    public String getAnswer_type() {
        return answer_type;
    }

    public void setAnswer_type(String answer_type) {
        this.answer_type = answer_type;
    }
}
