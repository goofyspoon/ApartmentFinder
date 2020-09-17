package myProject;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UsersDB extends JpaRepository<Users, Integer> {

    Users findByUserId(int userId);
    Users deleteByUserId(int userId);
    Users findByUserName(String userName);
    Users deleteByUserName(String userName);

}

