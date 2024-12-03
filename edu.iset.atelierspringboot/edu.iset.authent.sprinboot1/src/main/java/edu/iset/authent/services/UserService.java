package edu.iset.authent.services;
import java.util.List;

import edu.iset.authent.entities.User;

public interface UserService {
	public List<User> getAllUtilisateur();
	public User findUtilisateurById(Long id);
	public User addUtilisateur(User utilisateur);
	public User updateUtilisateur(User utilisateur);
	void deleteUtilisateur(Long id);
	public User getUtilisateurByMail(String mail);
	public User getUtilisateurById(Long employeeId);

}
