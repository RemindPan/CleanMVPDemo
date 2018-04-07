package com.example.data.entity;

import java.io.Serializable;

/**
 * Created by tinyfight on 2018/4/6.
 */

public class CityEntity implements Serializable {
    private String ID;
    private String cityName;
    private String cityEN;
    private String townID;
    private String townName;
    private String townEN;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityEN() {
        return cityEN;
    }

    public void setCityEN(String cityEN) {
        this.cityEN = cityEN;
    }

    public String getTownID() {
        return townID;
    }

    public void setTownID(String townID) {
        this.townID = townID;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public String getTownEN() {
        return townEN;
    }

    public void setTownEN(String townEN) {
        this.townEN = townEN;
    }
}
