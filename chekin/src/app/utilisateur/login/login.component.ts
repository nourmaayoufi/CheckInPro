import { Component, OnInit } from '@angular/core';
import { UtilisateurService } from 'src/app/utilisateur.service';
import { CommonModule } from '@angular/common';
import { FormsModule, NgForm } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  email: string = '';
  password: string = '';

  constructor(
    private utilisateurService: UtilisateurService,
    private router: Router,
    private snackBar: MatSnackBar
  ) {}

  ngOnInit(): void {}

  public login(addForm: NgForm): void {
    if (!this.email || !this.password) {
      this.snackBar.open('Veuillez remplir tous les champs.', 'Fermer', {
        duration: 3000,
      });
      return;
    }

    const loginData = { email: this.email, password: this.password };

    this.utilisateurService.login(this.email, this.password).subscribe(
      (response: any) => {
        console.log('Connexion réussie', response);
        this.snackBar.open('Connexion réussie !', 'Fermer', {
          duration: 3000,
        });
        this.router.navigate(['/list-utilisateurs']);
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        console.error('Erreur lors de la connexion', error.message);
        this.snackBar.open('Identifiants incorrects.', 'Fermer', {
          duration: 3000,
        });
        addForm.reset();
      }
    );
  }
}
