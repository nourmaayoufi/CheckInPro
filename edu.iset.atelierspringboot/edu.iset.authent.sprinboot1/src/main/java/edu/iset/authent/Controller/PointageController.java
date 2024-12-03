package edu.iset.authent.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import edu.iset.authent.entities.Pointage;
import edu.iset.authent.services.PointageService;

@RestController
@RequestMapping("/pointages")
@CrossOrigin(origins = "http://localhost:4200")
public class PointageController {

    @Autowired
    private PointageService pointageService;

    @GetMapping("/")
    public List<Pointage> getAllPointages() {
        return pointageService.getAllPointages();
    }

    @PostMapping("/add")
    public Pointage addPointage(@RequestBody Pointage pointage) {
        return pointageService.addPointage(pointage);
    }

    @PutMapping("/update")
    public Pointage updatePointage(@RequestBody Pointage pointage) {
        return pointageService.updatePointage(pointage);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePointage(@PathVariable Long id) {
        pointageService.deletePointage(id);
    }

    @GetMapping("/user/{userId}")
    public List<Pointage> getPointagesByUserId(@PathVariable Long userId) {
        return pointageService.getPointagesByUserId(userId);
    }
}
