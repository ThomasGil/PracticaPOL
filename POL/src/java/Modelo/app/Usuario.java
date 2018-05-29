/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.app;

import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Personal
 */

@Entity
public class Usuario {
    
    @Id
    @Column
    public int id;
    
    @Column
    public Date fecha_nacimiento;
    
    @Column
    public boolean activo;
    
    @Column
    public Dependencia dependencia;
    
    @Column
    public Perfil[] perfil;
    public List<Fila> filas;

    public Usuario(int id, Date fecha_nacimiento, boolean activo, Dependencia dependencia, Perfil[] perfil, List<Fila> filas) {
        this.id = id;
        this.fecha_nacimiento = fecha_nacimiento;
        this.activo = activo;
        this.dependencia = dependencia;
        this.perfil = perfil;
        this.filas = filas;
    }
    
}
