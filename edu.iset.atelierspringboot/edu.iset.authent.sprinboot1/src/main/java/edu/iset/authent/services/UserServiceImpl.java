package edu.iset.authent.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.iset.authent.entities.User;
import edu.iset.authent.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository utilisateurRepo;

    @Override
    public List<User> getAllUtilisateur() {
        // Récupère tous les utilisateurs
        return utilisateurRepo.findAll();
    }

    @Override
    public User addUtilisateur(User utilisateur) {
        // Sauvegarde un nouvel utilisateur dans la base de données
        return utilisateurRepo.save(utilisateur);
    }

    @Override
    public User findUtilisateurById(Long id) {
        // Recherche un utilisateur par son id
        Optional<User> utilisateur = utilisateurRepo.findById(id);
        // Si l'utilisateur existe, il est retourné, sinon null
        return utilisateur.orElse(null);
    }

    @Override
    public User updateUtilisateur(User utilisateur) {
        // Si l'utilisateur existe déjà, on le met à jour
        if (utilisateurRepo.existsById(utilisateur.getId())) {
            return utilisateurRepo.save(utilisateur);
        }
        // Si l'utilisateur n'existe pas, on retourne null
        return null;
    }

    @Override
    public void deleteUtilisateur(Long id) {
        // Supprimer un utilisateur par son id
        if (utilisateurRepo.existsById(id)) {
            utilisateurRepo.deleteById(id);
        } else {
            // Log ou gestion d'erreur si l'utilisateur n'existe pas
            System.out.println("Utilisateur non trouvé pour suppression");
        }
    }
    @Override
    public User getUtilisateurByMail(String mail) {
        User user = utilisateurRepo.findByMail(mail);
        if (user == null) {
            throw new RuntimeException("Utilisateur non trouvé");
        }
        return user;
    }
    public User getUtilisateurById(Long id) {
        return utilisateurRepo.findById(id).orElse(null);
    }

}
