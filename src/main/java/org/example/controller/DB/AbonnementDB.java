package org.example.controller.DB;

import org.example.Interface.Utilisateur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AbonnementDB extends Env {

    public void suscribeService(int idService, int idEmployee) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {
            String sql = "INSERT INTO abonnement (idService, idEmployee) VALUES (?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, idService);
            stmt.setInt(2, idEmployee);

            stmt.executeUpdate();
            System.out.println("Abonnement réussi !");
        } catch (Exception ex) {
            System.out.println("Erreur d'abonnement : " + ex.getMessage());
        }
    }

    public void unsubscribeService(int idService, int idEmployee) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {
            String sql = "DELETE FROM abonnement WHERE idService = ? AND idEmployee = ?";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, idService);
            stmt.setInt(2, idEmployee);

            int rows = stmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Désabonnement réussi !");
            } else {
                System.out.println("Vous n'étiez pas abonné à ce service.");
            }

        } catch (Exception ex) {
            System.out.println("Erreur de désabonnement : " + ex.getMessage());
        }
    }

}
