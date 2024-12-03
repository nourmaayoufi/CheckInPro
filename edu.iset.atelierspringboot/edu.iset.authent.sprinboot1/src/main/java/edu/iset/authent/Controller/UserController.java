package edu.iset.authent.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import edu.iset.authent.entities.User;
import edu.iset.authent.services.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")  // Pour permettre les requêtes de l'application Angular
public class UserController {

    @Autowired
    private UserService utilisateurService;

    // Gérer la pré-requête OPTIONS pour CORS
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/login", method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> handleOptions() {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User utilisateur) {
        try {
            // Rechercher l'utilisateur par son mail
            User user = utilisateurService.getUtilisateurByMail(utilisateur.getMail());

            // Vérifier si l'utilisateur est trouvé
            if (user == null) {
                // Retourner une réponse avec un code 404 si l'utilisateur n'est pas trouvé
                return ResponseEntity.status(404)
                                     .header(HttpHeaders.CONTENT_TYPE, "application/json")
                                     .body(new LoginResponse("Utilisateur non trouvé", null));
            }

            // Vérifier les informations de connexion
            if (user.getPsw().equals(utilisateur.getPsw()) && user.getRole().equals(utilisateur.getRole())) {
                // Retourner une réponse de connexion réussie
                return ResponseEntity.ok()
                                     .header(HttpHeaders.CONTENT_TYPE, "application/json")
                                     .body(new LoginResponse("Connexion réussie !", user.getRole()));
            } else {
                // Retourner une réponse d'erreur si les informations sont incorrectes
                return ResponseEntity.status(401)
                                     .header(HttpHeaders.CONTENT_TYPE, "application/json")
                                     .body(new LoginResponse("Informations de connexion incorrectes", null));
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Retourner une réponse d'erreur serveur en cas d'exception
            return ResponseEntity.status(500)
                                 .header(HttpHeaders.CONTENT_TYPE, "application/json")
                                 .body(new LoginResponse("Erreur interne du serveur", null));
        }
    }

    // Classe interne pour structurer la réponse JSON
    public static class LoginResponse {
        private String message;
        private String role;

        public LoginResponse(String message, String role) {
            this.message = message;
            this.role = role;
        }

        public String getMessage() {
            return message;
        }

        public String getRole() {
            return role;
        }
    }
}
