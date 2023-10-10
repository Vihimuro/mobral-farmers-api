package mobral.himuro.farmers.mobralAPI.repository;

import mobral.himuro.farmers.mobralAPI.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
