// Fichier: src/main/java/edu/iset/authent/repositories/PointageRepository.java

package edu.iset.authent.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import edu.iset.authent.entities.Pointage;

public interface PointageRepository extends JpaRepository<Pointage, Long> {
    List<Pointage> findByUserId(Long userId);
}
