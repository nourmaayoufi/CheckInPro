package edu.iset.authent.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import edu.iset.authent.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByMail(String mail);
    // JpaRepository fournit déjà les méthodes de base comme save(), findById(), etc.
}




