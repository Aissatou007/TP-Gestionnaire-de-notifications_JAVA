package org.example.view;
import org.example.service.EmployeeService;
import org.example.service.ServiceManager;

import java.sql.SQLOutput;
import java.util.Scanner;
public class InterfaceAdmin {
    public void InterfaceAdmin(){
        System.out.println("Bienvennue sur votre interface admin !");
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.Voir les services ");
        System.out.println("2.Ajouter un  service ");
        System.out.println("3.Lister les membres ");
        System.out.println("4.Ajouter un membre ");
        System.out.println("5.Quitter ");
        int choice = scanner.nextInt();


            switch (choice){
                case 1:
                    new ServiceManager().listerService();
                    break;
                case 2:
                    new ServiceManager().enregistrerService();
                    break;
                 case 3:
                   new EmployeeService().listeEmpoyee();
                   break;
                case 4:
                    new EmployeeService().enregistrerUtilisateur();
                    break;
                case 5:
                    System.out.println("A la prochaine");
                    break;
                default:
                    System.out.println("Choix indisponible");


            }


    }
}
