package org.example.controller.DB;

import org.example.service.EmployeeService;
import org.example.service.ServiceManager;
import org.example.view.InterfaceAdmin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class AdminDB extends Env {
    public  void saveAdmin(Admin a){

        try(Connection con = DriverManager.getConnection(url , user , pass)) {
            String sql = "INSERT INTO admin (nom, prenom, email , motDePasse) VALUE (?,?,?,?)";
            PreparedStatement stmtt = con.prepareStatement(sql);

            stmtt.setString(1, a.getNom());
            stmtt.setString(2, a.getPrenom());
            stmtt.setString(3, a.getEmail());
            stmtt.setString(4, a.getMotDePasse());



            stmtt.executeUpdate();
            System.out.println("Enrégistrement éffectuer");

        } catch (Exception ex) {
            System.out.printf("Erreur de l'enregistrement : " + " " + ex.getMessage());
        }
    }
    public Admin authentificationn(String prenom, String motDePasse) {
        InterfaceAdmin interfaceAdmin;
        Admin admin = null;
        try (Connection con = DriverManager.getConnection(url, user, pass)) {
            //pour Admin
            String sql = "SELECT * FROM admin WHERE prenom = ? AND motDePasse = ?";
            //pour Admin
            PreparedStatement stmtt = con.prepareStatement(sql);

            //pour Admin
            stmtt.setString(1, prenom);
            stmtt.setString(2, motDePasse);


            //pour employe
            ResultSet rss = stmtt.executeQuery();
            //pour employe
            if (rss.next()) {
                admin = new Admin(
                        rss.getString("nom"),
                        rss.getString("prenom"),
                        rss.getString("email"),
                        rss.getString("motDePasse")
                );
            }
            InterfaceAdmin();
            System.out.println("employé recuperer avec succès");


        } catch (Exception ex) {
            System.out.printf("Erreur de connection : " + " " + ex.getMessage());

        }
        return admin;
    }

        private void InterfaceAdmin(){
            System.out.println("Bienvennue sur votre interface admin !");
            Scanner scanner = new Scanner(System.in);
            System.out.println("1.Voir les services ");
            System.out.println("2.Ajouter un  service ");
            System.out.println("3.Lister les membres ");
            System.out.println("4.Ajouter un membre ");
            System.out.println("5.Voir les abonnées ");
            System.out.println("6.Envoyer notification ");
            int choice = scanner.nextInt();

            do {
                switch (choice) {
                    case 1:
                        new ServiceManager().listerService();
                        break;
                    case 2:
                        new ServiceManager().enregistrerService();
                        break;
                    case 3:
                        new EmployeeService().enregistrerUtilisateur();
                        break;


                }
            } while (choice != 6);

        }
    }



