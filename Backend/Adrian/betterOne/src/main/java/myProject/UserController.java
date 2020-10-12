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

    @GetMapping("/Users/{userId}")
    public List<Users> findByUserId(@PathVariable(value = "userId") int userId){
        System.out.println("ERROR" + userId);
        return (List<Users>) db.findByUserId(userId);
    }

    @DeleteMapping("/Users/{userId}")
    public List<Users> deleteByUserId(@PathVariable(value = "userId") int userId){
        return (List<Users>) db.deleteByUserId(userId);
    }

    @GetMapping("/User/{userName}")
    public List<Users> findByUserName(@PathVariable(value = "userName") String userName){
       return (List<Users>) db.findByUserName(userName);
    }

    @DeleteMapping("/User/{userName}")
    public List<Users> deleteByUserId(@PathVariable(value = "userName") String userName){
        return db.deleteByUserName(userName);
    }

    @DeleteMapping("/Users")
    public void deleteAll(){
        db.deleteAll();
    }


}
