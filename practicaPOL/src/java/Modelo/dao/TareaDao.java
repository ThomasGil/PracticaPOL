/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.dao;

import Modelo.hibernate.Tarea;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author Personal
 */
public class TareaDao {
    private SessionFactory session;
    
    public TareaDao(SessionFactory session){
        this.session = session;
    }
    
    public List<Tarea> obtenerTareas(){
        
        List<Tarea> tareas;
        session.getCurrentSession().beginTransaction();
        tareas = session.getCurrentSession().createQuery("from Tarea").list();
        session.getCurrentSession().getTransaction();
        
        return tareas;
    }
}
