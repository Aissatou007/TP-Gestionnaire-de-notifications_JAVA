package org.example.controller.DB;
import org.example.model.Service;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceDB extends Env {
    public void saveService(Service service){
        try(Connection con = DriverManager.getConnection(url , user , pass)) {
            String sql = "INSERT INTO Service (nom, description) VALUE (?,?)";
            PreparedStatement stmts = con.prepareStatement(sql);

            stmts.setString(1, service.getNom());
            stmts.setString(2, service.getDescription());

            stmts.executeUpdate();
            System.out.println("Service ajouter avec  succès");

        }catch(Exception ex) {
            System.out.printf("Erreur de l'enregistrement : " + " " + ex.getMessage());
        }
    }
    public List<Service> serviceList(){
        List<Service> listeService = new ArrayList<>();
        try(Connection con = DriverManager.getConnection(url , user , pass)) {
            String sql = "SELECT * FROM service";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Service service = new Service(
                        resultSet.getInt("id"),
                        resultSet.getString("nom"),
                        resultSet.getString("description")
                );
                listeService.add(service);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return listeService; 
    }
    public void abonnementEmployeeAuService(int employeeId, int serviceId) {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {
            String sql = "INSERT INTO Abonnement (idEmployee, idService) VALUES (?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, employeeId);
            stmt.setInt(2, serviceId);
            stmt.executeUpdate();
            System.out.println("Abonnement ajouté avec succès");
        } catch (Exception ex) {
            System.out.println("Erreur lors de l'abonnement : " + ex.getMessage());
        }
    }
}
