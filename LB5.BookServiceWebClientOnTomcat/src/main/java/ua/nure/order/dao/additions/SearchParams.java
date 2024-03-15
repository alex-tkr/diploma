package ua.nure.order.dao.additions;

public class SearchParams {
    private String pattern;
    private String pharmacist;

    public SearchParams(String pattern, String pharmacist) {
        this.pattern = pattern;
        this.pharmacist = pharmacist;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getPharmacist() {
        return pharmacist;
    }

    public void setPharmacist(String pharmacist) {
        this.pharmacist = pharmacist;
    }
}
