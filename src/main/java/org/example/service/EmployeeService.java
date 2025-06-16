package org.example.service;

import org.example.Interface.Utilisateur;
import org.example.controller.DB.EmployeDB;
import org.example.model.Employee;
import org.example.view.InterfaceUtilisateur;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeService implements Utilisateur {
    @Override
    public void creerCompte() {
        System.out.println("Bienvenue sur Alerte+");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nom :");
        String nom = scanner.nextLine();
        System.out.println("Prenom :");
        String prenom = scanner.nextLine();
        System.out.println("Votre email : ");
        String email = scanner.nextLine();
        System.out.println("le mot de passe : ");
        String motDePasse = scanner.nextLine();

        Employee employee = new Employee(nom , prenom , email, motDePasse);


        new  EmployeDB().saveEmploye(employee);
        System.out.println("Votre compte à eté créer avec succès !!");

    }

    @Override
    public void utilisateurListe() {

        List<Employee> ListeEmployee = new EmployeDB().employeeList();
        System.out.println("La liste des abonnées sont :");
        for (Employee e :ListeEmployee){
            System.out.println("Nom : "+" "+ e.getNom() + "\n" +" Prenom :"+" "+e.getPrenom());
        }
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void authentification(){
        System.out.println("Une seule connexion, et tout vous alerte !");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Prenom :");
        String prenom = scanner.nextLine();

        System.out.println("le mot de passe : ");
        String motDePasse = scanner.nextLine();

        Employee employee = new EmployeDB().authentification(prenom,motDePasse);
        if(employee != null){
            new InterfaceUtilisateur().InterfaceUtilisateur(employee.getId());

        }

    }

}
