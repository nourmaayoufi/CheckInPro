package edu.iset.authent.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import edu.iset.authent.entities.Pointage;
import edu.iset.authent.repositories.PointageRepository;

@Service
public class PointageServiceImpl implements PointageService {

    @Autowired
    private PointageRepository pointageRepository;

    @Override
    public List<Pointage> getAllPointages() {
        return pointageRepository.findAll();
    }

    @Override
    public Pointage addPointage(Pointage pointage) {
        return pointageRepository.save(pointage);
    }

    @Override
    public Pointage updatePointage(Pointage pointage) {
        return pointageRepository.save(pointage);
    }

    @Override
    public void deletePointage(Long id) {
        pointageRepository.deleteById(id);
    }

    @Override
    public List<Pointage> getPointagesByUserId(Long userId) {
        return pointageRepository.findByUserId(userId);
    }
}
