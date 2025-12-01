package hibernate;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Session session = null;

        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory()) {

            session = factory.getCurrentSession();
            Transaction tx = session.beginTransaction();

            Libro libro1 = new Libro("Hibernate para DAM2", "Alumnado Dam2", 26);
            session.persist(libro1);
            // Crear usuario
            Usuario usuario1 = new Usuario("Cristina", "crispf@sanclemente.net");
            session.persist(usuario1);
            tx.commit();

            session = factory.getCurrentSession();
            tx = session.beginTransaction();

            libro1.setAutor("Antonio Lopez");

            Libro megerdLibro = (Libro) session.merge(libro1);

            tx.commit();

            tx = session.beginTransaction();
            session.remove(megerdLibro);
            tx.commit();

        } catch (Exception e) {
            System.out.println("Problemas: " + e.getMessage());
        }
    }
}