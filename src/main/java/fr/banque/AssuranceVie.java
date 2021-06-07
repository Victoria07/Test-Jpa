package fr.banque;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table
public class AssuranceVie extends Compte implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="taux", nullable = false)
    private double taux;

    @Column(name = "dateFin")
    private LocalDate dateFin;

    public AssuranceVie(){

    }

    public AssuranceVie(double taux, LocalDate dateFin){
        this.taux = taux;
        this.dateFin = dateFin;
    }

    public AssuranceVie(String numero, double solde, double taux, LocalDate dateFin) {
        super(numero, solde);
        this.taux = taux;
        this.dateFin = dateFin;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }
}
