package project.controllers;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import project.models.Mago;
import project.models.Monstruo;
import project.views.BattleView;

public class Controller {

    private BattleView vista;

    public Controller(BattleView vista) {
        this.vista = vista;
        crearMago();
        crearMostruo();
    }


    public void crearMago(){
        Session session = null;
        Mago magoCreado  = vista.getValoresmago();
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory()) {
            session = factory.getCurrentSession();
            Transaction tx = session.beginTransaction();
            session.persist(magoCreado);
            tx.commit();

        } catch (Exception e) {
            System.out.println("Problemas crendo el mago");
        }
    }

     public void crearMostruo(){
        Session session = null;
        Monstruo monstruoCreado  = vista.getValoresMonstruo();
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory()) {
            session = factory.getCurrentSession();
            Transaction tx = session.beginTransaction();
            session.persist(monstruoCreado);
            tx.commit();

        } catch (Exception e) {
            System.out.println("Problemas crendo el mago");
        }
    }


}
