package com.example.ApartmentFinder.app;

import org.json.JSONException;
import org.json.JSONObject;

public class Apartment {
    private int apartment_id;
    private String address;
    private String apartment_name;
    private String location;
    private int num_rooms;
    private int rating;
    private int rent;

    public Apartment(JSONObject apartment) throws JSONException {
        this.apartment_id = apartment.getInt("apartment_id");
        this.address = apartment.getString("address");
        this.apartment_name = apartment.getString("apartment_name");
        this.location = apartment.getString("location");
        this.num_rooms = apartment.getInt("num_rooms");
        this.rating = apartment.getInt("rating");
        this.rent = apartment.getInt("rent");
    }

    Apartment(int apartment_id, String address, String apartment_name){
        this.apartment_id = apartment_id;
        this.address = address;
        this.apartment_name = apartment_name;
    }

    public int getApartment_id() {
        return apartment_id;
    }

    public void setApartment_id(int apartment_id) {
        this.apartment_id = apartment_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getApartment_name() {
        return apartment_name;
    }

    public void setApartment_name(String apartment_name) {
        this.apartment_name = apartment_name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNum_rooms() {
        return num_rooms;
    }

    public void setNum_rooms(int num_rooms) {
        this.num_rooms = num_rooms;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }
}
