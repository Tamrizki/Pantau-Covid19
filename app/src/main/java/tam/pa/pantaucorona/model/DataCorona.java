package tam.pa.pantaucorona.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataCorona {

    @SerializedName("provinceState")
    @Expose
    private Object provinceState;
    @SerializedName("countryRegion")
    @Expose
    private String countryRegion;
    @SerializedName("lastUpdate")
    @Expose
    private Long lastUpdate;
    @SerializedName("lat")
    @Expose
    private Float lat;
    @SerializedName("long")
    @Expose
    private Float _long;
    @SerializedName("confirmed")
    @Expose
    private Integer confirmed;
    @SerializedName("recovered")
    @Expose
    private Integer recovered;
    @SerializedName("deaths")
    @Expose
    private Integer deaths;
    @SerializedName("active")
    @Expose
    private Integer active;
    @SerializedName("admin2")
    @Expose
    private Object admin2;
    @SerializedName("fips")
    @Expose
    private Object fips;
    @SerializedName("combinedKey")
    @Expose
    private String combinedKey;
    @SerializedName("incidentRate")
    @Expose
    private Object incidentRate;
    @SerializedName("peopleTested")
    @Expose
    private Object peopleTested;
    @SerializedName("iso2")
    @Expose
    private String iso2;
    @SerializedName("iso3")
    @Expose
    private String iso3;

    public DataCorona(String countryRegion, Integer confirmed, String iso2) {
        this.countryRegion = countryRegion;
        this.confirmed = confirmed;
        this.iso2 = iso2;
    }

    public Object getProvinceState() {
        return provinceState;
    }

    public void setProvinceState(Object provinceState) {
        this.provinceState = provinceState;
    }

    public String getCountryRegion() {
        return countryRegion;
    }

    public void setCountryRegion(String countryRegion) {
        this.countryRegion = countryRegion;
    }

    public Long getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Long lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getLong() {
        return _long;
    }

    public void setLong(Float _long) {
        this._long = _long;
    }

    public Integer getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Integer confirmed) {
        this.confirmed = confirmed;
    }

    public Integer getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Object getAdmin2() {
        return admin2;
    }

    public void setAdmin2(Object admin2) {
        this.admin2 = admin2;
    }

    public Object getFips() {
        return fips;
    }

    public void setFips(Object fips) {
        this.fips = fips;
    }

    public String getCombinedKey() {
        return combinedKey;
    }

    public void setCombinedKey(String combinedKey) {
        this.combinedKey = combinedKey;
    }

    public Object getIncidentRate() {
        return incidentRate;
    }

    public void setIncidentRate(Object incidentRate) {
        this.incidentRate = incidentRate;
    }

    public Object getPeopleTested() {
        return peopleTested;
    }

    public void setPeopleTested(Object peopleTested) {
        this.peopleTested = peopleTested;
    }

    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }

    public String getIso3() {
        return iso3;
    }

    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }

}
