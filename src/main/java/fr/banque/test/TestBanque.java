package fr.banque.test;

import fr.banque.Client;
import fr.banque.Compte;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class TestBanque {
    public static void main(String[] args) {
        //Lie le fichier
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque");
        //Cherche les entités
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Compte compte = new Compte("FR485454858",1520.25);
        //Creation du compte en mémoire
        em.persist(compte);


        Set<Compte> comptesClient = new HashSet<Compte>();
        comptesClient.add(compte);

        Client client1 = new Client(4,"rue des champs","AbricoLand","45250","Durand","Pierre", LocalDate.of(1985,8,25),comptesClient);
        Client client2 = new Client(5,"rue des fleurs","AbricoLand","45250","Lefevre","Paulette", LocalDate.of(1975,2,15),comptesClient);
        em.persist(client1);
        em.persist(client2);

        //Creation en base
        em.getTransaction().commit();

        emf.close();
        em.close();
    }
}
