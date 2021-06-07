package fr.banque;

import javax.persistence.*;

@Entity
@Table(name="adresses")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Adresse {

    @Id
    //Auto par defaut
    @GeneratedValue
    private Long id;

    @Column(name="numero", nullable = false)
    private int numero;

    @Column(name = "rue", length = 100, nullable = false)
    private String rue;

    @Column(name = "ville", length = 100, nullable = false)
    private String ville;

    @Column(name = "codePostal", length = 10,nullable = false)
    private String codePostal;

    public Adresse(){

    }

    public Adresse(int numero, String rue, String ville, String codePostal) {
        this.numero = numero;
        this.rue = rue;
        this.ville = ville;
        this.codePostal = codePostal;
    }

    public Adresse(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }
}
