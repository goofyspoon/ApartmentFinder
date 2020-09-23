package myProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UsersDB db;

    @GetMapping("/Users")
    List<Users> hello() {
        return db.findAll();
    }


    @PostMapping("/User")
    Users createUser(Users u) {
        db.save(u);
        return u;
    }

    @GetMapping("/User/{userId}")
    public Users getByUserID(@PathVariable(value = "userId") int userId){
        System.out.println("ERROR" + userId);
        return db.findOne(userId);
    }

    @DeleteMapping("/User/{userId}")
    public Users deleteUserByID(@PathVariable(value = "userId") int userId){
        return db.deleteByUserId(userId);
    }

    //@GetMapping("/User/{userName}")
    //public Users getUserByUserName(@PathVariable(value = "userName") String userName){
    //    return db.findByUserName(userName);
    //}

    @DeleteMapping("/User/{userName}")
    public Users deleteUserByID(@PathVariable(value = "userName") String userName){
        return db.deleteByUserName(userName);
    }

    @DeleteMapping("/Users")
    public void deleteAll(){
        db.deleteAll();
    }


}
