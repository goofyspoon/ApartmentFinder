package myProject;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UsersDB extends JpaRepository<Users, Integer> {

    List<Users> findByUserId(int userId);
    List<Users> deleteByUserId(int userId);
    List<Users> findByUserName(String userName);
    List<Users> deleteByUserName(String userName);
}

