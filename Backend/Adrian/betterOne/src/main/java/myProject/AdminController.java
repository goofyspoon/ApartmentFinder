package myProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {

    @Autowired
    AdminsDB Adb;

    @GetMapping("/Admins")
    List<Admin> hello() {
        return Adb.findAll();
    }


    @PostMapping("/Admin")
    Admin createUser(Admin u) {
       Adb.save(u);
        return u;
    }

    @GetMapping("/Admin/{userId}")
    public Admin getByUserID(@PathVariable(value = "userId") int userId){
        System.out.println("ERROR" + userId);
        return Adb.findByUserId(userId);
    }

    @DeleteMapping("/Admin/{userId}")
    public Admin deleteUserByID(@PathVariable(value = "userId") int userId){
        return Adb.deleteByUserId(userId);
    }

    //@GetMapping("/User/{userName}")
    //public Users getUserByUserName(@PathVariable(value = "userName") String userName){
    //    return db.findByUserName(userName);
    //}

    @DeleteMapping("/Admin/{userName}")
    public Admin deleteUserByID(@PathVariable(value = "userName") String userName){
        return Adb.deleteByUserName(userName);
    }

    @DeleteMapping("/Admin")
    public void deleteAll(){
        Adb.deleteAll();
    }


}
