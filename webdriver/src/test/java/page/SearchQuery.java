package page;

public class SearchQuery {
    private String place;
    private String arrivalDate;
    private String departureDate;
    private String adults;
    private String children;

    public SearchQuery(String place, String arrivalDate, String departureDate, String adults, String children) {
        this.place = place;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.adults = adults;
        this.children = children;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getAdults() {
        return adults;
    }

    public void setAdults(String adults) {
        this.adults = adults;
    }

    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }
}
