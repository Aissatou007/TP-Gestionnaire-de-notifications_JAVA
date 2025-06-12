package org.example.controller.DB;

import org.example.model.Employee;
import org.example.model.Service;
import org.example.service.ServiceManager;
import org.example.view.InterfaceUtilisateur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeDB extends Env {
    public void saveEmploye(Employee e) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {
            String sql = "INSERT INTO Employee (nom, prenom, email , motDePasse) VALUE (?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, e.getNom());
            stmt.setString(2, e.getPrenom());
            stmt.setString(3, e.getEmail());
            stmt.setString(4, e.getMotDePasse());


            stmt.executeUpdate();
            System.out.println("Enrégistrement éffectuer");

        } catch (Exception ex) {
            System.out.printf("Erreur de l'enregistrement : " + " " + ex.getMessage());
        }
    }

    public Employee authentification(String prenom, String motDePasse) {
        InterfaceUtilisateur interfaceUtilisateur;
        Employee employee = null;
        try (Connection con = DriverManager.getConnection(url, user, pass)) {
            //pour Employe
            String sql = "SELECT * FROM employee WHERE prenom = ? AND motDePasse = ?";
            //pour Employe
            PreparedStatement stmt = con.prepareStatement(sql);

            //pour employe
            stmt.setString(1, prenom);
            stmt.setString(2, motDePasse);


            //pour employe
            ResultSet rs = stmt.executeQuery();
            //pour employe
            if (rs.next()) {
                employee = new Employee(
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("email"),
                        rs.getString("motDePasse")
                );
            }
            InterfaceUtilisateur();
            System.out.println("employé recuperer avec succès");


        } catch (Exception ex) {
            System.out.printf("Erreur de connection : " + " " + ex.getMessage());

        }
        return employee;
    }

    private void InterfaceUtilisateur() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.Voir les services ");
        System.out.println("2.S'abonner à un service ");
        System.out.println("3.Se désabonner d'un service ");
        System.out.println("4.Envoyer notification ");
        int choice = scanner.nextInt();
        do {
            switch (choice) {
                case 1:
                    new ServiceManager().listerService();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("Retour");
                    break;
            }
        } while (choice != 5);


    }

    public List<Employee> employeeList() {
        List<Employee> listeEmployee = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(url, user, pass)) {
            String sql = "SELECT * FROM employee";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee(
                        resultSet.getString("nom"),
                        resultSet.getString("premon"),
                        resultSet.getString("email"),
                        resultSet.getString("motDePasse")
                        );
                listeEmployee.add(employee);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listeEmployee;
    }
}


