package fr.banque;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "comptes")
public class Compte implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "numero",length = 50,unique = true)
    private String numero;

    @Column(name = "solde")
    private double solde;

   @ManyToMany(mappedBy = "comptes")
   private Set<Client> clients;

    @OneToMany
    private Set<Operation> operations;


    {this.clients = new HashSet<>();
    this.operations = new HashSet<>(); }
    public Compte(){

    }

    public Compte(String numero, double solde) {
        this.numero = numero;
        this.solde = solde;
    }

    public Compte(String numero, double solde, Set<Client> clients) {
        this.numero = numero;
        this.solde = solde;
        this.clients = clients;
    }

    public Compte(String numero, double solde, Set<Client> clients, Set<Operation> operations) {
        this.numero = numero;
        this.solde = solde;
        this.clients = clients;
        this.operations = operations;
    }

    public Set<Operation> getOperations() {
        return operations;
    }

    public void setOperations(Set<Operation> operations) {
        this.operations = operations;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }
}
