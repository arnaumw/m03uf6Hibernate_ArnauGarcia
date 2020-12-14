package HibernateUtil;
// Generated 09-dic-2020 21:45:07 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Jugadores generated by hbm2java
 */
public class Jugadores  implements java.io.Serializable {


     private int idJugador;
     private String nombreJugador;
     private double mediaPuntosJugador;
     private boolean campeonJugador;
     private String equiposJugador;
     private Date nacimientoJugador;

    public Jugadores() {
    }

    public Jugadores(int idJugador, String nombreJugador, double mediaPuntosJugador, boolean campeonJugador, String equiposJugador, Date nacimientoJugador) {
       this.idJugador = idJugador;
       this.nombreJugador = nombreJugador;
       this.mediaPuntosJugador = mediaPuntosJugador;
       this.campeonJugador = campeonJugador;
       this.equiposJugador = equiposJugador;
       this.nacimientoJugador = nacimientoJugador;
    }
   
    public int getIdJugador() {
        return this.idJugador;
    }
    
    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }
    public String getNombreJugador() {
        return this.nombreJugador;
    }
    
    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }
    public double getMediaPuntosJugador() {
        return this.mediaPuntosJugador;
    }
    
    public void setMediaPuntosJugador(double mediaPuntosJugador) {
        this.mediaPuntosJugador = mediaPuntosJugador;
    }
    public boolean isCampeonJugador() {
        return this.campeonJugador;
    }
    
    public void setCampeonJugador(boolean campeonJugador) {
        this.campeonJugador = campeonJugador;
    }
    public String getEquiposJugador() {
        return this.equiposJugador;
    }
    
    public void setEquiposJugador(String equiposJugador) {
        this.equiposJugador = equiposJugador;
    }
    public Date getNacimientoJugador() {
        return this.nacimientoJugador;
    }
    
    public void setNacimientoJugador(Date nacimientoJugador) {
        this.nacimientoJugador = nacimientoJugador;
    }




}

