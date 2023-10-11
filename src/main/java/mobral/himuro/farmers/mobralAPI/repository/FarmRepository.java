package mobral.himuro.farmers.mobralAPI.repository;

import mobral.himuro.farmers.mobralAPI.domain.Farm;
import mobral.himuro.farmers.mobralAPI.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmRepository extends JpaRepository<Farm, Long> {
    Page<Farm> findAllByUser(User user, Pageable pageable);
}