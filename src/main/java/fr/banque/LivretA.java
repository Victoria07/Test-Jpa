package fr.banque;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "livretA")
public class LivretA extends Compte implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "taux")
    private double taux;

    public LivretA(){

    }

    public LivretA(double taux){
        this.taux = taux;
    }

    public LivretA(String numero, double solde, double taux) {
        super(numero, solde);
        this.taux = taux;
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
}
