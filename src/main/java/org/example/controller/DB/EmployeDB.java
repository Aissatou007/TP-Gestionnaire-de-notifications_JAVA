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
                       rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("email"),
                        rs.getString("motDePasse")
               );
            }
            //new InterfaceUtilisateur().InterfaceUtilisateur();
            System.out.println("Un plaisir de vous revoir " +" "+employee.getNom() +" "+employee.getPrenom() +" !");
        } catch (Exception ex) {
            System.out.printf("Erreur de connection : " + " " + ex.getMessage());

        }
        return employee;
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
                        resultSet.getString("prenom"),
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


