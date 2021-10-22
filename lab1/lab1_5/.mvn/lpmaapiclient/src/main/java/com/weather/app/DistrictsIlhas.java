package com.weather.app;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DistrictsIlhas {
    
    @SerializedName("owner")
    @Expose
    private String owner;
    
    
    @SerializedName("country")
    @Expose
    private String country;


    @SerializedName("data")
    @Expose
    private List<CityInfo> data = null;


    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<CityInfo> getData() {
        return this.data;
    }

    public void setData(List<CityInfo> data) {
        this.data = data;
    }

}
