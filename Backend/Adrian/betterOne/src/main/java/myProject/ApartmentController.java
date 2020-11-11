package myProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApartmentController {

    @Autowired
    ApartmentDB database;

    @GetMapping("/Apartments")
    List<Apartments> hello() {
        return database.findAll();
    }

    @GetMapping("/Apartments/RentAsc")
    List<Apartments> getApartmentsByRentAsc()
    {
        //List<Apartments> f = database.findAll(Sort.by(Sort.Direction.ASC, "rent"));
        return database.findAllByOrderByRentAsc();
    }
    @GetMapping("/Apartments/RentDesc")
    List<Apartments> getApartmentsByRentDesc()
    {
        //List<Apartments> f = database.findAll(Sort.by(Sort.Direction.ASC, "rent"));
        return database.findAllByOrderByRentDesc();
    }
    @GetMapping("/Apartments/RoomsAsc")
    List<Apartments> getApartmentsByRoomsAsc()
    {
        //List<Apartments> f = database.findAll(Sort.by(Sort.Direction.ASC, "rent"));
        return database.findAllByOrderByNumRoomsAsc();
    }
    @GetMapping("/Apartments/RoomsDesc")
    List<Apartments> getApartmentsByRoomsDesc()
    {
        //List<Apartments> f = database.findAll(Sort.by(Sort.Direction.ASC, "rent"));
        return database.findAllByOrderByNumRoomsDesc();
    }
    @GetMapping("/Apartments/RatingAsc")
    List<Apartments> getApartmentsByRatingAsc()
    {
        //List<Apartments> f = database.findAll(Sort.by(Sort.Direction.ASC, "rent"));
        return database.findAllByOrderByRatingAsc();
    }
    @GetMapping("/Apartments/RatingDesc")
    List<Apartments> getApartmentsByRatingDesc()
    {
        //List<Apartments> f = database.findAll(Sort.by(Sort.Direction.ASC, "rent"));
        return database.findAllByOrderByRatingDesc();
    }


    @PostMapping("/Apartment")
    Apartments createApartment(Apartments apartment) {
        database.save(apartment);
        return apartment;
    }

    @GetMapping("/Apartments/{apartmentId}")
    public List<Apartments> findByApartmentId(@PathVariable(value = "userId") int userId){
        System.out.println("ERROR" + userId);
        return (List<Apartments>) database.findByApartmentId(userId);
    }

    @DeleteMapping("/Apartments/{userId}")
    public List<Apartments> deleteByUserId(@PathVariable(value = "userId") int userId){
        return (List<Apartments>) database.deleteByApartmentId(userId);
    }

    @GetMapping("/Apartments/{userName}")
    public List<Apartments> findByApartmentName(@PathVariable(value = "userName") String userName){
        return (List<Apartments>) database.findByApartmentName(userName);
    }

    @DeleteMapping("/Apartments/{userName}")
    public List<Apartments> deleteByUserId(@PathVariable(value = "userName") String userName){
        return database.deleteByApartmentName(userName);
    }

    @DeleteMapping("/Apartments")
    public void deleteAll(){
        database.deleteAll();
    }




}