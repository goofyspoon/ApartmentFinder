package myProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApartmentController {

    @Autowired
    ApartmentsDB db;

    @GetMapping("/Apartments")
    List<Apartments> hello() {
        return db.findAll();
    }


    @PostMapping("/Apartment")
    Apartments createApartment(Apartments apartment) {
        db.save(apartment);
        return apartment;
    }

    @GetMapping("/Apartments/{apartmentId}")
    public List<Apartments> findByApartmentId(@PathVariable(value = "userId") int userId){
        System.out.println("ERROR" + userId);
        return (List<Apartments>) db.findByApartmentId(userId);
    }

    @DeleteMapping("/Apartments/{userId}")
    public List<Apartments> deleteByUserId(@PathVariable(value = "userId") int userId){
        return (List<Apartments>) db.deleteByApartmentId(userId);
    }

    @GetMapping("/Apartments/{userName}")
    public List<Apartments> findByApartmentName(@PathVariable(value = "userName") String userName){
        return (List<Apartments>) db.findByApartmentName(userName);
    }

    @DeleteMapping("/Apartments/{userName}")
    public List<Apartments> deleteByUserId(@PathVariable(value = "userName") String userName){
        return db.deleteByApartmentName(userName);
    }

    @DeleteMapping("/Apartments")
    public void deleteAll(){
        db.deleteAll();
    }


}