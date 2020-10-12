package myProject;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ApartmentDB extends JpaRepository<Apartments, Integer> {
//needs more gets and a sort
    List<Apartments> findByApartmentId(int userId);
    List<Apartments> deleteByApartmentId(int userId);
    List<Apartments> findByApartmentName(String userName);
    List<Apartments> deleteByApartmentName(String userName);
}
