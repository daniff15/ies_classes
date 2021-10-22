package com.weather.app;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CityInfo {

    @SerializedName("idRegiao")
    @Expose
    private Integer idRegiao;

    @SerializedName("idAreaAviso")
    @Expose
    private String idAreaAviso;

    @SerializedName("idConcelho")
    @Expose
    private Integer idConcelho;

    @SerializedName("globalIdLocal")
    @Expose
    private Integer globalIdLocal;

    @SerializedName("latitude")
    @Expose
    private String latitude;

    @SerializedName("idDistrito")
    @Expose
    private Integer idDistrito;

    @SerializedName("local")
    @Expose
    private String local;
    
    @SerializedName("longitude")
    @Expose
    private String longitude;    

    public Integer getIdRegiao() {
        return this.idRegiao;
    }

    public void setIdRegiao(Integer idRegiao) {
        this.idRegiao = idRegiao;
    }

    public String getIdAreaAviso() {
        return this.idAreaAviso;
    }

    public void setIdAreaAviso(String idAreaAviso) {
        this.idAreaAviso = idAreaAviso;
    }

    public Integer getIdConcelho() {
        return this.idConcelho;
    }

    public void setIdConcelho(Integer idConcelho) {
        this.idConcelho = idConcelho;
    }

    public Integer getGlobalIdLocal() {
        return this.globalIdLocal;
    }

    public void setGlobalIdLocal(Integer globalIdLocal) {
        this.globalIdLocal = globalIdLocal;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Integer getIdDistrito() {
        return this.idDistrito;
    }

    public void setIdDistrito(Integer idDistrito) {
        this.idDistrito = idDistrito;
    }

    public String getLocal() {
        return this.local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }


    
}
