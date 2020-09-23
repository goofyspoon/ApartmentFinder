package myProject;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminsDB extends JpaRepository<Admin, Integer> {

    Admin findByUserId(int userId);
    Admin deleteByUserId(int userId);
    Admin findByUserName(String userName);
    Admin deleteByUserName(String userName);
}

