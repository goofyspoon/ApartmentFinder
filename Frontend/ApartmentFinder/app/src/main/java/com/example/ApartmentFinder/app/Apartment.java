package com.example.ApartmentFinder.app;

import org.json.JSONException;
import org.json.JSONObject;

public class Apartment {
    private int apartmentId;
    private String address;
    private String apartmentName;
    private String location;
    private int numRooms;
    private int rating;
    private int rent;

    public Apartment(JSONObject apartment) throws JSONException {
        this.apartmentId = apartment.getInt("apartmentId");
        this.address = apartment.getString("address");
        this.apartmentName = apartment.getString("apartmentName");
        this.location = apartment.getString("location");
        this.numRooms = apartment.getInt("numRooms");
        this.rating = apartment.getInt("rating");
        this.rent = apartment.getInt("rent");
    }

    public Apartment(int apartment_id, String address, String apartment_name){
        this.apartmentId = apartment_id;
        this.address = address;
        this.apartmentName = apartment_name;
    }


    public int getApartment_id() {
        return apartmentId;
    }

    public void setApartment_id(int apartment_id) {
        this.apartmentId = apartment_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getApartment_name() {
        return apartmentName;
    }

    public void setApartment_name(String apartment_name) {
        this.apartmentName = apartment_name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNum_rooms() {
        return numRooms;
    }

    public void setNum_rooms(int num_rooms) {
        this.numRooms = num_rooms;
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
