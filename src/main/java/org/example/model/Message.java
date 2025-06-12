package org.example.model;

public class Message {
    private int id , idUtilisateur;
    public String  description ;

    public Message(int id, int idUtilisateur, String description) {
        this.id = id;
        this.idUtilisateur = idUtilisateur;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
