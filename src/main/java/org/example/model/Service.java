package org.example.model;

public class Service {
    private int idService ;
    public String nom , description;

    public Service( String nom, String description) {
        this.nom = nom;
        this.description = description;
    }
    public Service(int idService, String nom, String description) {
        this.idService = idService;
        this.nom = nom;
        this.description = description;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
