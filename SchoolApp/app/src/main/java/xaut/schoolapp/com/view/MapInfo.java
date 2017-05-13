package xaut.schoolapp.com.view;

/**
 * Created by xiaoleilei on 2017/5/1.
 */

public class MapInfo {
    private double mLatitude;
    private double mLongitude;
    private String mName;


    public MapInfo(double latitude, double longitude, String name){
        super();
        mLatitude = latitude;
        mLongitude = longitude;
        mName = name;
    }

    public void setLatitude(double latitude) {
        mLatitude = latitude;
    }

    public void setName(String name) {
        mName = name;
    }

    public void setLongitude(double longitude) {
        mLongitude = longitude;
    }

    public double getLatitude() {
        return mLatitude;
    }

    public double getLongitude() {
        return mLongitude;
    }

    public String getName() {
        return mName;
    }
}
