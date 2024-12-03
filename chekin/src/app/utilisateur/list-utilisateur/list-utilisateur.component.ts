import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { UtilisateurService } from 'src/app/utilisateur.service';
import { CommonModule } from '@angular/common';
import { FormsModule, NgForm } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { Utilisateur } from 'src/app/utilisateur.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-list-utilisateur',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './list-utilisateur.component.html',
  styleUrls: ['./list-utilisateur.component.css']
})

export class ListUtilisateurComponent implements OnInit {
 
  public utilisateurs: Utilisateur[] = [];
  public deleteUtilisateur!: Utilisateur;
  public editUtilisateur: Utilisateur = {
    id: 0, 
    name: '',
    prenom: '',
    email: '',
    adresse: '',
    motDePasse: '',
    role: '',
    isVlidated: false,
};
currentPage: number = 1; 
pageSize: number = 3; 

  

  constructor(private utilisateurService: UtilisateurService) {}

  ngOnInit() {
    this.getUtilisateurs();
  }

  public getUtilisateurs(): void {
    this.utilisateurService.getUtilisateurs().subscribe(
      (response: Utilisateur[]) => {
        this.utilisateurs = response;
        console.log(this.utilisateurs);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onAddUtilisateur(addForm: NgForm): void {
    const button = document.getElementById('add-Utilisateur-form');
    
    if (button) {
      button.click(); // Appeler le clic uniquement si l'élément existe
    } else {
      console.error('Le bouton "Fermer" n\'a pas été trouvé dans le DOM');
    }
  
    this.utilisateurService.ajouterUtilisateur(addForm.value).subscribe(
      (response: Utilisateur) => {
        console.log(response);
        this.getUtilisateurs();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }
  

  public onUpdateUtilisateur(Utilisateur: Utilisateur): void {
    if (!Utilisateur.id) {
        console.error('ID utilisateur manquant !');
        return;
    }
    this.utilisateurService.mettreAJourUtilisateur(Utilisateur).subscribe(
        (response: Utilisateur) => {
            console.log('Utilisateur mis à jour avec succès', response);
            this.getUtilisateurs();
        },
        (error: HttpErrorResponse) => {
            console.error('Erreur lors de la mise à jour de l\'utilisateur:', error.message);
            alert('Erreur: ' + error.message);
        }
    );
}


  public onDeleteUtilisateur(id: number): void {
   
      
      this.utilisateurService.deleteUtilisateur(id).subscribe(
        (response: void) => {
          console.log('Utilisateur supprimé avec succès:', response);
          this.getUtilisateurs();  
        },
        (error: HttpErrorResponse) => {
          console.error('Erreur lors de la suppression de l\'utilisateur:', error.message);
          alert(error.message); 
        }
      );
    
  }
  
  


  public searchUtilisateurs(key: string): void {
    console.log(key);
    const results: Utilisateur[] = [];
    for (const utilisateur of this.utilisateurs) {
      if (
        utilisateur.name.toLowerCase().includes(key.toLowerCase()) ||
        utilisateur.email.toLowerCase().includes(key.toLowerCase())
      ) {
        results.push(utilisateur);
      }
    }
    this.utilisateurs = results;
    if (results.length === 0 || !key) {
      this.getUtilisateurs();
    }
  }

  public onOpenModal(Utilisateur: Utilisateur | null, mode: string): void {
    const container = document.getElementById('main-container');
    if (!container) {
      console.error('Conteneur introuvable');
      return;
    }
  
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
  
    if (mode === 'add') {
      button.setAttribute('data-target', '#addUtilisateurModal');
    } else if (mode === 'edit' && Utilisateur) {
      this.editUtilisateur = Utilisateur;
      button.setAttribute('data-target', '#updateUtilisateurModal');
    } else if (mode === 'delete' && Utilisateur) {
      this.deleteUtilisateur = Utilisateur; 
      button.setAttribute('data-target',  '#deleteUtilisateurModal');
    }
  
    container.appendChild(button);
    button.click();
    button.remove();
  }
      
      changePage(page: number): void {
        this.currentPage = page;
    }
}  