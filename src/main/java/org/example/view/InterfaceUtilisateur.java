package org.example.view;

import org.example.controller.DB.ServiceDB;
import org.example.service.ServiceManager;

import java.sql.SQLOutput;
import java.util.Scanner;

public class InterfaceUtilisateur {
    public void InterfaceUtilisateur (){
        int choice;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1.Voir les services ");
            System.out.println("2.S'abonner à un service ");
            System.out.println("3.Se désabonner d'un service ");
            System.out.println("4.Envoyer notification ");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    new ServiceManager().listerService();
                    break;
                case 2:
                    System.out.println("en cours");
                    break;
                case 3:
                   //new ServiceDB().abonnementEmployeeAuService(employ,service);
                   break;
                case 4:
                    System.out.println("En cours");
                    break;
                case 5:
                    System.out.println("Retour");
                    break;
            }
        }while (choice !=5);
    }
}
