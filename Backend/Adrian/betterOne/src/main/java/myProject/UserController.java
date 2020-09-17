package myProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UsersDB db;

    @RequestMapping("/Users")
    List<Users> hello() {
        return db.findAll();
    }


    @PostMapping("/Users")
    Users createUser(Users u) {
        db.save(u);
        return u;
    }

    @GetMapping("/Users/{userId}")
    public Users getUserByUserID(@PathVariable(value = "userId") int userId){
        return db.findByUserId(userId);
    }

    @DeleteMapping("/Users/{userId}")
    public Users deleteUserByID(@PathVariable(value = "userId") int userId){
        return db.deleteByUserId(userId);
    }

    @GetMapping("/Users/{userName}")
    public Users getUserByUserName(@PathVariable(value = "userName") String userName){
        return db.findByUserName(userName);
    }

    @DeleteMapping("/Users/{userName}")
    public Users deleteUserByID(@PathVariable(value = "userName") String userName){
        return db.deleteByUserName(userName);
    }

    @DeleteMapping("/Users")
    public void deleteAll(){
        db.deleteAll();
    }


}
