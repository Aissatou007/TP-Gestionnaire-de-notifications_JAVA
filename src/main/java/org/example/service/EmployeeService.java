package org.example.service;

import org.example.controller.DB.EmployeDB;
import org.example.model.Employee;
import org.example.view.InterfaceUtilisateur;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeService {
    public void enregistrerUtilisateur(){
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
    }
    public void authentification(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Prenom :");
        String prenom = scanner.nextLine();

        System.out.println("le mot de passe : ");
        String motDePasse = scanner.nextLine();

        Employee employee = new EmployeDB().authentification(prenom,motDePasse);
        if(employee != null){
            new InterfaceUtilisateur().InterfaceUtilisateur();

        }
    }
    public void listeEmpoyee(){
        List<Employee> ListeEmployee = new EmployeDB().employeeList();
        for (Employee e :ListeEmployee){
            System.out.println("Nom : "+" "+ e.getNom() + "\n" +" Prenom :"+" "+e.getPrenom());
        }
    }
}
