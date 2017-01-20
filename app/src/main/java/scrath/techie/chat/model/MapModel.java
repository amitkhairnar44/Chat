package scrath.techie.chat.model;

/**
 * Created by TUSHAR-AMIT on 1/18/2017.
 */

public class MapModel {
    private String latitude;
    private String longitude;

    public MapModel() {
    }

    public MapModel(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

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
}
