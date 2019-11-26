package com.epam.ta.model;

import java.util.Objects;

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

    @Override
    public String toString() {
        return "SearchQuery{" +
                "place='" + place + '\'' +
                ", arrivalDate='" + arrivalDate + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", adults='" + adults + '\'' +
                ", children='" + children + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchQuery that = (SearchQuery) o;
        return getAdults().equals(that.getAdults()) &&
                getChildren().equals(that.getChildren()) &&
                Objects.equals(getPlace(), that.getPlace()) &&
                Objects.equals(getArrivalDate(), that.getArrivalDate()) &&
                Objects.equals(getDepartureDate(), that.getDepartureDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPlace(), getArrivalDate(), getDepartureDate(), getAdults(), getChildren());
    }
}
