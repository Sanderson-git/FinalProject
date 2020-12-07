package co.grandcircus.FinalProject.SQL;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	public Optional<User> findFirstByUsername(String username);
}
