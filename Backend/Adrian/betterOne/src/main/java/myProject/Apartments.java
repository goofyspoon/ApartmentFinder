package myProject;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Apartments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer apartmentId;

    @Column
    String apartmentName;

    @Column
    int rating;

    @Column
    int rent;

    @Column
    String location;

    @Column
    String address;

    @Column
    int numRooms;

    public void setApartmentName(String apartmentName) {
        this.apartmentName = apartmentName;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNumRooms(int numRooms) {
        this.numRooms = numRooms;
    }

    public Integer getApartmentId() {
        return apartmentId;
    }

    public String getApartmentName() {
        return apartmentName;
    }

    public int getRating(){
        return rating;
    }

    public int getRent() {
        return rent;
    }

    public String getLocation() {
        return location;
    }

    public String getAddress() {
        return address;
    }

    public int getNumRooms() {
        return numRooms;
    }
}
