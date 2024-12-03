// Fichier: src/main/java/edu/iset/authent/services/PointageService.java

package edu.iset.authent.services;

import java.util.List;
import edu.iset.authent.entities.Pointage;

public interface PointageService {
    public List<Pointage> getAllPointages();
    public Pointage addPointage(Pointage pointage);
    public Pointage updatePointage(Pointage pointage);
    public void deletePointage(Long id);
    public List<Pointage> getPointagesByUserId(Long userId);
}
