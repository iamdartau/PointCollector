package models;

public class Transport_detail {

    private int id;
    private String site_name, comment;

    public Transport_detail(String site_name, String comment) {
        this.site_name = site_name;
        this.comment = comment;
    }

    public Transport_detail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSite_name() {
        return site_name;
    }

    public void setSite_name(String site_name) {
        this.site_name = site_name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
