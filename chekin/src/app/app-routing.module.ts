import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AjouterUtilisateurComponent } from './utilisateur/ajouter-utilisateur/ajouter-utilisateur.component';
import { ListUtilisateurComponent } from './utilisateur/list-utilisateur/list-utilisateur.component';
import { LoginComponent } from './utilisateur/login/login.component';

const routes: Routes = [
  { path: 'ajouter-utilisateur', component: AjouterUtilisateurComponent },
  { path: 'list-utilisateurs', component: ListUtilisateurComponent },
  { path: 'login', component: LoginComponent }, // Route pour la page de login


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
