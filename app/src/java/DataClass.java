package com.example.android.quakereport;

/**
 * Created by ishan123 on 18-02-2018.
 */

public class DataClass {
    private double mMag;
    private String mCity;
    private long mTime;
    private String mUrl;

    public DataClass(double mag, String city, long time, String url ){
        this.mMag = mag;
        this.mCity = city;
        this.mTime = time;
        this.mUrl = url;
    }


    public double getMag(){return mMag;}
    public String getCity(){return mCity;}
    public long getTime(){return mTime;}
    public String getUrl(){return mUrl;}
}
