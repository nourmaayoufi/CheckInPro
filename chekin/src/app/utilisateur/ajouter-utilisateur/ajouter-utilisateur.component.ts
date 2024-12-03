import { Component } from '@angular/core';
import { UtilisateurService } from 'src/app/utilisateur.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule, Router } from '@angular/router';
import { Utilisateur } from 'src/app/utilisateur.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-ajouter-utilisateur',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './ajouter-utilisateur.component.html',
  styleUrls: ['./ajouter-utilisateur.component.css']
})
export class AjouterUtilisateurComponent {
  utilisateur: Utilisateur = {
    name: '',
    prenom: '',
    email: '',
    adresse: '',
    motDePasse: '',
    role: '',
    isVlidated: false,
  };

  form: any;

  constructor(
    private UtilisateurService: UtilisateurService,
    private router: Router,  // Injection du service Router
    private snackBar: MatSnackBar
  ) {}

  ajouterUtilisateur() {
    if (
      this.utilisateur.name &&
      this.utilisateur.prenom &&
      this.utilisateur.email &&
      this.utilisateur.adresse &&
      this.utilisateur.motDePasse &&
      this.utilisateur.role &&
      this.utilisateur.isVlidated
    ) {
      this.UtilisateurService.ajouterUtilisateur(this.utilisateur).subscribe(
        (response) => {
          console.log('Utilisateur ajouté avec succès :', response);
          // Affichage du message de succès avec MatSnackBar
          this.snackBar.open('Utilisateur ajouté avec succès !', 'Fermer', {
            duration: 3000, // Durée en ms
          });

          // Réinitialisation des champs
          this.utilisateur = {
            name: '',
            prenom: '',
            email: '',
            adresse: '',
            motDePasse: '',
            role: '',
            isVlidated: false,
          };

          console.log('Redirection vers la page login');
          this.router.navigate(['/login']);

        },
        (error) => {
          console.error("Erreur lors de l'ajout de l'utilisateur", error);
          this.snackBar.open('Erreur lors de l\'ajout de l\'utilisateur !', 'Fermer', {
            duration: 3000, // Durée en ms
          });
        }
      );
    } else {
      this.snackBar.open('Veuillez remplir tous les champs.', 'Fermer', {
        duration: 3000, // Durée en ms
      });
    }
  }
}
