package Modelo.hibernate;
// Generated 30/05/2018 02:43:43 PM by Hibernate Tools 4.3.1


import java.sql.Date;

/**
 * Usuarios generated by hbm2java
 */
public class Usuarios  implements java.io.Serializable {


     private int id;
     private Date fechaNacimiento;
     private boolean activo;
     private String dependencia;

    public Usuarios() {
    }

    public Usuarios(int id, Date fechaNacimiento, boolean activo, String dependencia) {
       this.id = id;
       this.fechaNacimiento = fechaNacimiento;
       this.activo = activo;
       this.dependencia = dependencia;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }
    
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public boolean isActivo() {
        return this.activo;
    }
    
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    public String getDependencia() {
        return this.dependencia;
    }
    
    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }




}

