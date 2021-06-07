package fr.diginamic;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="client")

public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(name = "NOM", length = 50, nullable = false,unique = true)
    private String nom ;

    @Column(name = "PRENOM",length = 50, nullable = false,unique = true)
    private String prenom;

    @OneToMany(mappedBy = "client")
    private Set<Emprunt> emprunt;

    //Constructeur
    public Client(){

    }

    //Get et set
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }




}
