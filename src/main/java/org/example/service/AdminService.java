package org.example.service;

import org.example.controller.DB.AdminDB;
import org.example.model.Admin;
import org.example.model.Admin;
import org.example.view.InterfaceAdmin;


import java.util.Scanner;

public class AdminService {
    public void enregistrerAdmin(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nom :");
        String nom = scanner.nextLine();
        System.out.println("Prenom :");
        String prenom = scanner.nextLine();
        System.out.println("Votre email : ");
        String email = scanner.nextLine();
        System.out.println("le mot de passe : ");
        String mot2passe = scanner.nextLine();

        Admin admin = new Admin(nom , prenom , email ,mot2passe);


        new  AdminDB().saveAdmin(admin);
    }
    public void authentificationn(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Prenom :");
        String prenom = scanner.nextLine();

        System.out.println("le mot de passe : ");
        String motDePasse = scanner.nextLine();

        Admin admin = new AdminDB().authentificationn(prenom,motDePasse);
        if(admin != null){
            new InterfaceAdmin().InterfaceAdmin();

        }



    }
}

