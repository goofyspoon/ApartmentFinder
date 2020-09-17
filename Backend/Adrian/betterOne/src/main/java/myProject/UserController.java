package myProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UsersDB db;

    @Autowired
    LoginDB db2;


    @RequestMapping("/Users")
    List<Users> hello() {
        return db.findAll();
    }


    @PostMapping("/Users")
    Users createUser(Users u) {
        db.save(u);
        return u;
    }

    @PostMapping("/Login")
    Login createUser(@RequestBody Login requestBody) {
        db2.save(requestBody);
        return requestBody;
    }

}
