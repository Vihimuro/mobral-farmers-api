package mobral.himuro.farmers.mobralAPI.repository;

import mobral.himuro.farmers.mobralAPI.domain.Farm;
import mobral.himuro.farmers.mobralAPI.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FarmRepository extends JpaRepository<Farm, Long> {
    @Query("SELECT f FROM Farm f WHERE f.user = ?1")
    List<Farm> findAllUserFarms(User user);
}