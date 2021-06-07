package fr.diginamic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;



public class TestJPA {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_essai");
        EntityManager em = emf.createEntityManager();

        Livre livre1 = em.find(Livre.class, 5L);
        System.out.println(livre1);

        TypedQuery<Livre> query = em.createQuery( "SELECT l FROM Livre l WHERE l.titre = 'Germinal'", Livre.class );
        System.out.println(query.getResultList());

        TypedQuery<Livre> query2 = em.createQuery( "SELECT l FROM Livre l WHERE l.auteur = 'Poyatos Remi'", Livre.class );
        System.out.println(query2.getResultList().get(0)); // possibilité de mettre un foreach a la place du get(0) si plusieurs livres

        TypedQuery<Livre> query3 = em.createQuery( "SELECT l FROM Livre l ", Livre.class );
        System.out.println(query3.getResultList());


        em.getTransaction().begin();

//       Livre monLivre = new Livre("Comment reussir son SQL", "Poyatos Remi");
//       em.persist(monLivre);


//        livre1.setTitre("Du plaisir dans la cuisine");

//        Livre livre2 = em.find(Livre.class, 1L);
//        if ( null != livre2 ) {
//            em.remove( livre2 );
//        }

        em.getTransaction().commit();

        em.close();
        emf.close();

    }

}
