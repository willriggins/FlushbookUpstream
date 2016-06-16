package com.theironyard;

/**
 * Created by jeffryporter on 6/16/16.
 */
public class Toilet
{
    Integer id;
    String Facility;
    double lon;
    double lat;
    int easeOfAccess;
    int capacity;
    int cleanliness;

    public Toilet()
    {
    }

    public Toilet(Integer id, String facility, double lon, double lat, int easeOfAccess, int capacity, int cleanliness)
    {
        this.id = id;
        Facility = facility;
        this.lon = lon;
        this.lat = lat;
        this.easeOfAccess = easeOfAccess;
        this.capacity = capacity;
        this.cleanliness = cleanliness;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getFacility()
    {
        return Facility;
    }

    public void setFacility(String facility)
    {
        Facility = facility;
    }

    public double getLon()
    {
        return lon;
    }

    public void setLon(double lon)
    {
        this.lon = lon;
    }

    public double getLat()
    {
        return lat;
    }

    public void setLat(double lat)
    {
        this.lat = lat;
    }

    public int getEaseOfAccess()
    {
        return easeOfAccess;
    }

    public void setEaseOfAccess(int easeOfAccess)
    {
        this.easeOfAccess = easeOfAccess;
    }

    public int getCapacity()
    {
        return capacity;
    }

    public void setCapacity(int capacity)
    {
        this.capacity = capacity;
    }

    public int getCleanliness()
    {
        return cleanliness;
    }

    public void setCleanliness(int cleanliness)
    {
        this.cleanliness = cleanliness;
    }
}
