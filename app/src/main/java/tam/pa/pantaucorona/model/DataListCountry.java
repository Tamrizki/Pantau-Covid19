package tam.pa.pantaucorona.model;

public class DataListCountry {
    private String country_flag;
    private String country_name;
    private String confirmed;

    public DataListCountry(String country_flag, String country_name, String confirmed) {
        this.country_flag = country_flag;
        this.country_name = country_name;
        this.confirmed = confirmed;
    }

    public String getCountry_flag() {
        return country_flag;
    }

    public String getCountry_name() {
        return country_name;
    }

    public String getConfirmed() {
        return confirmed;
    }
}
