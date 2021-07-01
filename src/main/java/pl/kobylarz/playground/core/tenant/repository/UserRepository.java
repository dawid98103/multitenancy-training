package pl.kobylarz.playground.core.tenant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kobylarz.playground.core.tenant.model.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Integer> {
}
