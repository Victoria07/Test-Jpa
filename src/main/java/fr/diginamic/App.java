package fr.diginamic;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

    public static void main(String args[]){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp1");
        emf.close();

    }

}
