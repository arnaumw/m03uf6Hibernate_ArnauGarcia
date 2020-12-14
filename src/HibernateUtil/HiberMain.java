/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HibernateUtil;

import java.util.Iterator;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import HibernateUtil.HibernateUtil;
import HibernateUtil.Jugadores;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author arnaugarciaalvarez
 */
public class HiberMain {

    /**
     * @param args the command line arguments
     */
    
    
    private static SessionFactory factory;
    Jugadores j1 = new Jugadores(5, "Magic Johnson 2", 20.0, true, "LA Lakers", new java.sql.Date(1959 - 8 - 14));
    
    public static void main(String[] args) {
        
        //Session s1 = ConexionBD();       
        //Query q1 = s1.createQuery("from Jugadores");       
        //Iterator it1 = q1.iterate();
        
        //crearJugador(5, "Magic Johnson", 20.0, true, "LA Lakers", new java.sql.Date(1959 - 8 - 14));
        //actualizarJugador(4, "O'Neal");
        //eliminarJugador(5);
        mostrarJugadores();

        
    }
    
    
    private static void iniciarSession(){
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex){
            System.err.println("Failed to create sessionFactory object " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static void mostrarJugadores(){
        iniciarSession();
        Session s1 = factory.openSession();
        Transaction tx = null;
        
        try{
            tx = s1.beginTransaction();
            List<Jugadores> ListaJugadores = s1.createQuery("from Jugadores").list();
            
            System.out.println("----------------------------------------------------------------");
            
            for(Iterator it = ListaJugadores.iterator(); it.hasNext();){
                Jugadores jugador = (Jugadores) it.next();
                System.out.println(jugador.getIdJugador() + " ---> " + jugador.getNombreJugador() + " ---> " + jugador.getMediaPuntosJugador()
                + " ---> " + jugador.isCampeonJugador() + " ---> " + jugador.getEquiposJugador() + " ---> " + jugador.getNacimientoJugador());
                //System.out.println(jugador);
            }
            
            System.out.println("----------------------------------------------------------------");
            
            tx.commit();
            
        } catch (HibernateException e){
            if (tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
      
    public static void crearJugador(int Id, String nombre, double MediaPuntos, boolean campeon, String equipos, Date nacimiento){
        iniciarSession();
        Session s1 = factory.openSession();
        Transaction tx = null;
        
        try{
            
            tx = s1.beginTransaction();
            Jugadores jugador = new Jugadores(Id, nombre, MediaPuntos, campeon, equipos, nacimiento);
            s1.save(jugador);
            tx.commit();
            
        } catch (HibernateException e){
            if (tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
    
    public static void actualizarJugador(Jugadores jugador){
        iniciarSession();
        Session s1 = factory.openSession();
        Transaction tx = null;
        
        try{
            
            tx = s1.beginTransaction();
            //Jugadores jugador = (Jugadores) s1.get(Jugadores.class, Id);
            //jugador.setNombreJugador(nombre);
            s1.update(jugador);
            tx.commit();
            
        } catch (HibernateException e){
            if (tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
    
    public static void eliminarJugador(int Id){
        iniciarSession();
        Session s1 = factory.openSession();
        Transaction tx = null;
        
        try{
            
            tx = s1.beginTransaction();
            Jugadores jugador = (Jugadores) s1.get(Jugadores.class, Id);
            s1.delete(jugador);
            tx.commit();
            
        } catch (HibernateException e){
            if (tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
    
    
//    
//    
//    private static void mostrarJugadores(Iterator<Jugadores> it) {
//        while(it.hasNext()) {
//            
//            jugador = it.next();
//            
//            System.out.println(jugador.getIdJugador() + " ---> " + jugador.getNombreJugador() + " ---> " + jugador.getMediaPuntosJugador()
//            + " ---> " + jugador.isCampeonJugador() + " ---> " + jugador.getEquiposJugador() + " ---> " + jugador.getNacimientoJugador());
//        }
//    }
    
}
