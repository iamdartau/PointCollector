package models;

public class Alarms {

    private String Bts_name;
    private String alarm_name;
    private int id;

    public String getBts_name() {
        return Bts_name;
    }

    public void setBts_name(String bts_name) {
        Bts_name = bts_name;
    }

    public String getAlarm_name() {
        return alarm_name;
    }

    public void setAlarm_name(String alarm_name) {
        this.alarm_name = alarm_name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Alarms{" +
                "Bts_name='" + Bts_name + '\'' +
                ", alarm_name='" + alarm_name + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public Alarms(String bts_name, String alarm_name) {
        Bts_name = bts_name;
        this.alarm_name = alarm_name;
    }

    public Alarms(String bts_name, String alarm_name, int id) {

        Bts_name = bts_name;
        this.alarm_name = alarm_name;
        this.id = id;
    }
}
