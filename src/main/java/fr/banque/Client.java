package fr.banque;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;


@Entity
@Table(name = "clients")
public class Client extends Adresse implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nom",length = 50,nullable = false, unique = true)
    private String nom;

    @Column(name = "prenom",length = 50,nullable = false, unique = true)
    private String prenom;

    @Column(name = "dateNaissance",length = 50,nullable = false, unique = true)
    private LocalDate dateNaissance;

    @ManyToOne
    @JoinColumn(name = "id_banque")
    private Banque banque;

    @ManyToMany
    @JoinTable(name = "comptesClients",
            joinColumns = @JoinColumn(name = "id_client",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_compte",referencedColumnName = "id"))
    private Set<Compte> comptes;

    public Banque getBanque() {
        return banque;
    }

    public void setBanque(Banque banque) {
        this.banque = banque;
    }

    public Set<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(Set<Compte> comptes) {
        this.comptes = comptes;
    }

    public Client(){

    }

    public Client(String nom, String prenom, LocalDate dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }

    //Constructeur avec la classe Adresse
    public Client(int numero, String rue, String ville, String codePostal, String nom, String prenom, LocalDate dateNaissance,Banque banque) {
        super(numero, rue, ville, codePostal);
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.banque = banque;
    }

    public Client(int numero, String rue, String ville, String codePostal, String nom, String prenom, LocalDate dateNaissance, Banque banque, Set<Compte> comptes) {
        super(numero, rue, ville, codePostal);
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.banque = banque;
        this.comptes = comptes;
    }

    public Client(int numero, String rue, String ville, String codePostal, String nom, String prenom, LocalDate dateNaissance, Set<Compte> comptes) {
        super(numero, rue, ville, codePostal);
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.comptes = comptes;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }


}
