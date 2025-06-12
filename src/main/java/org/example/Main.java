package org.example;

import org.example.service.AdminService;
import org.example.service.EmployeeService;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bonjour");
        System.out.println("1. Creer un compte ");
        System.out.println("2.S'authentifier en tant qu'empoye");
        System.out.println("3.S'authentifier en tant qu'administrateur");
        System.out.println("4.Quitter");
        int choix;
         choix = scanner.nextInt();
            switch (choix){
                case 1:
                    new EmployeeService().enregistrerUtilisateur();
                    break;
                case 2:
                    new EmployeeService().authentification();
                    break;
                case 3:
                    new AdminService().authentificationn();
                case 4:
                    System.out.println("retour");
                default:
                    System.out.println("choix non dispo !");
            }

    }
}