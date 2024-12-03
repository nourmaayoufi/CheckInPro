import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module'; // Si vous avez un module de routage
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { FormsModule } from '@angular/forms'; 
// Importez les composants standalone ici
import { AjouterUtilisateurComponent } from './utilisateur/ajouter-utilisateur/ajouter-utilisateur.component';
import { ListUtilisateurComponent } from './utilisateur/list-utilisateur/list-utilisateur.component';
import { LoginComponent } from './utilisateur/login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    
    // Ne déclarez pas les composants standalone ici
  ],
  imports: [
    BrowserModule,
    AppRoutingModule, // Si vous avez un module de routage
    HttpClientModule,
    CommonModule,
    BrowserAnimationsModule,
    FormsModule,
    MatSnackBarModule,

    // Importez les composants standalone ici
    AjouterUtilisateurComponent,
    ListUtilisateurComponent,
       LoginComponent,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
