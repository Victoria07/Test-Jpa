package fr.banque;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "virements")
public class Virement extends Operation implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "beneficiaire")
    private String beneficiaire;

    public Virement(){

    }

    public Virement(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    public Virement(LocalDateTime date, double montant, String motif, String beneficiaire) {
        super(date, montant, motif);
        this.beneficiaire = beneficiaire;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }
}
