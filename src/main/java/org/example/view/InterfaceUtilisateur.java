package org.example.view;

import org.example.service.EmployeeService;
import org.example.service.ServiceManager;

import java.util.Scanner;

public class InterfaceUtilisateur  {
    public void InterfaceUtilisateur ( int employe){
        int choice;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1.Voir les services ");
            System.out.println("2.Liste utilisateur ");
            System.out.println("3.Ajouter un service ");
            System.out.println("4.S'abonner à un service");
            System.out.println("5.Envoyer une notification");
            System.out.println( "6.Quitter");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    new ServiceManager().afficherService();
                    break;
                case 2:
                    new EmployeeService().utilisateurListe();
                    break;
                case 3:
                   new ServiceManager().ajouterService();
                    break;
                case 4:
                    new ServiceManager().abonnerService(employe);
                    break;
                case 5:
                    System.out.println("Merci en cours");
                    break;
                case 6:
                    System.out.println("Merci et à la prochaine !!");
                    break;

            }
        }while (choice !=6);
    }
}
