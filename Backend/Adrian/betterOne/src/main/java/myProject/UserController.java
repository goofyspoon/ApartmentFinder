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
    Users createPerson(@RequestBody Users u) {
        db.save(u);
        return u;
    }

}
