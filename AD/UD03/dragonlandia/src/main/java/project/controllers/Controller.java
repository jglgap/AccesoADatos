package project.controllers;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import project.models.Bosque;
import project.models.Mago;
import project.models.Monstruo;
import project.views.BattleView;

public class Controller {

    private BattleView vista;

    public Controller(BattleView vista) {
        this.vista = vista;
        menu();
    }

    public void crearMago() {
        Session session = null;
        Mago magoCreado = vista.getValoresmago();
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory()) {
            session = factory.getCurrentSession();
            Transaction tx = session.beginTransaction();
            session.persist(magoCreado);
            tx.commit();

        } catch (Exception e) {
            System.out.println("Problemas crendo el mago");
        }
    }

    public void crearMostruo() {
        Session session = null;
        Monstruo monstruoCreado = vista.getValoresMonstruo();
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory()) {
            session = factory.getCurrentSession();
            Transaction tx = session.beginTransaction();
            session.persist(monstruoCreado);
            tx.commit();

        } catch (Exception e) {
            System.out.println("Problemas crendo el mago");
        }
    }

        // public void ataqueMago() {
        //     Session session = null;
        //     Mago mago = null;
        //     Monstruo monstruo = null;
        //     try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory()) {
                
        //         session = factory.getCurrentSession();
        //         Transaction tx = session.beginTransaction();
        //         mago = session.find(Mago.class, 1);
        //         monstruo = session.find(Monstruo.class, 1);
        //         tx.commit();
        //     } catch (Exception e) {
        //         System.out.println("Problemas ataque el mago");
        //     }
        //     if (monstruo.getVida()<=0) {
        //         System.out.println("el monstruo murio");
        //     }else{

        //         mago.ataque(monstruo);
        //     }
        //     System.out.println(monstruo.getVida());
        // }


        // public void ataqueMonstruo() {
        //     Session session = null;
        //     Mago mago = null;
        //     Monstruo monstruo = null;
        //     try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory()) {
                
        //         session = factory.getCurrentSession();
        //         Transaction tx = session.beginTransaction();
        //         mago = session.find(Mago.class, 1);
        //         monstruo = session.find(Monstruo.class, 1);
        //         tx.commit();
        //     } catch (Exception e) {
        //         System.out.println("Problemas ataque el monstruo");
        //     }
        //     System.out.println(monstruo.getNombre());
        //     if (mago.getVida() <= 0) {
        //         System.out.println("el mago murio");
        //     }else{
        //         monstruo.atacar(mago);
        //     }
        //     System.out.println(mago.getVida());
        // } 

        public void cambiarMonstruo(){
            Session session = null;
            Bosque bosque = null;
            Monstruo monstruo = null;
            try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory()) {
                
                session = factory.getCurrentSession();
                Transaction tx = session.beginTransaction();
                bosque = session.find(Bosque.class, 1);
                monstruo = session.find(Monstruo.class, 2);
                bosque.setMonstruoJefe(monstruo);
                System.out.println("El nuevo jefe del bosque es " + monstruo.getNombre());
                
                tx.commit();
            } catch (Exception e) {
                System.out.println("Problemas ataque el monstruo");
            }
            
        }

        public String hacerBatalla(){
            Session session = null;
            Monstruo monstruo = null;
            Mago mago = null;
            try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory()) {
                
                session = factory.getCurrentSession();
                Transaction tx = session.beginTransaction();
                mago = session.find(Mago.class, 1);
                monstruo = session.find(Monstruo.class, 1);
                while (monstruo.getVida()>0 && mago.getVida()>0) {
                    monstruo.atacar(mago);
                    session.merge(mago);
                    mago.ataque(monstruo);
                    session.merge(monstruo);
                }
                
                tx.commit();
            } catch (Exception e) {
                System.out.println("Problemas batalla");
            }

            String frase = "";
            if (monstruo.getVida()<=0) {
                frase = "monstruo murio";
            }else if (mago.getVida()<=0) {
                frase = "mago murio";
            }

          return frase;
        }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        boolean it = true;
        while (it) {
            System.out.println("1-Crear mago \n2-Crear monstruo \n3-hacer batalla \n4-cambiar mostruo");
            int opc = Integer.parseInt(sc.nextLine());
            switch (opc) {
                case 1:
                    crearMago();
                    break;
                case 2:
                    crearMostruo();
                case 3:
                    String frase = hacerBatalla();
                    vista.mostrarGanador(frase);
                    break;
 
                case 4:
                    cambiarMonstruo();
                default:
                    break;
            }

        }
    }

}
