package fr.diginamic;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "emprunt")
public class Emprunt implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "DATE_DEBUT")
    private Date date_debut;

    @Column(name = "delai", length = 10,nullable = true)
    private int delai;

    @Column(name = "DATE_FIN", nullable = true)
    private Date date_fin;

    @Column(name = "ID_Client")
    private Client client;




}
