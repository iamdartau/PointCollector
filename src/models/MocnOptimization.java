package models;
//Таблица mocn - оптимизация секторов, объединение с kcell
public class MocnOptimization {
    int id;
    String site;
    String comment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public MocnOptimization(String site, String comment) {
        this.site = site;
        this.comment = comment;
    }

    public MocnOptimization(int id, String site, String comment) {
        this.id = id;
        this.site = site;
        this.comment = comment;
    }
}
