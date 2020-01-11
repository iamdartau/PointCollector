package models;

public class Cell {
    private String Name;
    private String Cell_id;
    private int Azimut;
    private double directionToAb;
    private double latitude;
    private double longitude;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getDirectionToAb() {
        return directionToAb;
    }

    public void setDirectionToAb(double directionToAb) {
        this.directionToAb = directionToAb;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCell_id() {
        return Cell_id;
    }

    public void setCell_id(String cell_id) {
        Cell_id = cell_id;
    }

    public int getAzimut() {
        return Azimut;
    }

    public void setAzimut(int azimut) {
        Azimut = azimut;
    }

    public Cell(String name, String cell_id, int azimut, double directionToAb, double latitude, double longitude) {
        Name = name;
        Cell_id = cell_id;
        Azimut = azimut;
        this.directionToAb = directionToAb;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
