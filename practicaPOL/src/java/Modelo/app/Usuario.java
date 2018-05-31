/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.app;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author Personal
 */
public class Usuario {
    private int id;
    private Date fechaNacimiento;
    private boolean activo;
    private Dependencia dependencia;
    private Perfil[] perfil;
    private List<Fila> filas;

    public Usuario() {
    }

    public Usuario(int id, Date fechaNacimiento, boolean activo, Dependencia dependencia) {
        this.id = id;
        this.fechaNacimiento = fechaNacimiento;
        this.activo = activo;
        this.dependencia = dependencia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Dependencia getDependencia() {
        return dependencia;
    }

    public void setDependencia(Dependencia dependencia) {
        this.dependencia = dependencia;
    }

    public Perfil[] getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil[] perfil) {
        this.perfil = perfil;
    }

    public List<Fila> getFilas() {
        return filas;
    }

    public void setFilas(List<Fila> filas) {
        this.filas = filas;
    }
}
