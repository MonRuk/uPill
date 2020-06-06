package pl.coderslab.upill.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.upill.entity.Medicine;
import pl.coderslab.upill.entity.User;


import java.util.List;


@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {
    Medicine findMedicineByName(String name);

    @Query("select m from Medicine m where m.id=?1")
    Medicine findMedicineById(Long id);

    List<Medicine> findAllByUsers(User user);


}
