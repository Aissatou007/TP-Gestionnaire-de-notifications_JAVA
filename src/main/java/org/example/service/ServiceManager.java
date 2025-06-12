package org.example.service;
import org.example.controller.DB.Env;
import org.example.controller.DB.ServiceDB;
import org.example.model.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class ServiceManager {
    public void enregistrerService(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nom du service :");
        String nom = scanner.nextLine();
        System.out.println("Description du service : ");
        String description = scanner.nextLine();

        Service service = new Service(nom , description);
        new ServiceDB().saveService(service);
    }

    public void listerService(){
        List<Service> listeService = new ServiceDB().serviceList();
        for(Service s : listeService ){
            System.out.println("Nom : " + " " + s.getNom() + "| " + "Description : " + " "+ s.getDescription());
        }
    }

}
