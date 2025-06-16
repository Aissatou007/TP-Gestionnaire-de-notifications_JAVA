package org.example.service;
import org.example.Interface.ServiceInterface;
import org.example.controller.DB.AbonnementDB;
import org.example.controller.DB.Env;
import org.example.controller.DB.ServiceDB;
import org.example.model.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class ServiceManager implements ServiceInterface {
    @Override
    public void afficherService() {
        List<Service> listeService = new ServiceDB().serviceList();
        for(Service s : listeService ){
            System.out.println("Nom : " + " " + s.getNom() + "| " + "Description : " + " "+ s.getDescription());
        }
    }

    @Override
    public void ajouterService() {
        System.out.println("Ajouter un nouveau service et faites en profiter vos amis !!");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nom du service :");
        String nom = scanner.nextLine();
        System.out.println("Description du service : ");
        String description = scanner.nextLine();

        Service service = new Service(nom , description);
        new ServiceDB().saveService(service);
        System.out.println("Service ajouter avec succès !!");

    }

    @Override
    public void abonnerService(int idEmployee) {
        Scanner scanner = new Scanner(System.in);
        AbonnementDB abonnementDB = new AbonnementDB();


            List<Service> listeService = new ServiceDB().serviceList();
            for(Service s : listeService ){
                System.out.println("ID: "+s.getIdService()+ "  "+"Nom : " + " " + s.getNom());
            }

            System.out.println("ID du service :");
            int idService = scanner.nextInt();
        System.out.println();
            new AbonnementDB().suscribeService(idService,idEmployee);

            }



    @Override
    public void desabonnerService() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Votre email :");
        String email = scanner.nextLine();

        System.out.println("Nom du service à désabonner :");
        String nomService = scanner.nextLine();
    }


}
