package fr.banque;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "banques")
public class Banque extends Adresse implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nom",length = 50, unique = true)
    private String nom;

    @OneToMany
    private Set<Client> clients;


    //Initialisation dans le constructeur
    {this.clients = new HashSet<>(); }

    public Banque(){

    }

    public Banque(String nom) {
        this.nom = nom;
    }

    //Constructeur avec la classe adresse
    public Banque(int numero, String rue, String ville, String codePostal, String nom) {
        super(numero, rue, ville, codePostal);
        this.nom = nom;
    }

    public Banque(int numero, String rue, String ville, String codePostal, String nom, Set<Client> clients) {
        super(numero, rue, ville, codePostal);
        this.nom = nom;
        this.clients = clients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }



}
