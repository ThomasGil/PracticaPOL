/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.dao;

import Modelo.hibernate.Usuarios;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Personal
 */
public class UsuarioDao {
    private SessionFactory session;
    
    public UsuarioDao(SessionFactory session){
        this.session = session;
    }
    
    public void registrar(Usuarios usuario){
 
        session.getCurrentSession().beginTransaction();
        session.getCurrentSession().save(usuario);
        session.getCurrentSession().getTransaction().commit();
        
        
    }
    
    public void actualizar(Usuarios usuario){
        
        session.getCurrentSession().beginTransaction();
        session.getCurrentSession().update(usuario);
        session.getCurrentSession().getTransaction().commit();
        
    }
    
    public Usuarios buscar(int id){
        Usuarios usuario;
        
        session.getCurrentSession().beginTransaction();
        usuario = (Usuarios) session.getCurrentSession().get(Usuarios.class, id);
        session.getCurrentSession().getTransaction().commit();
        
        return usuario;
    }
    
    public void eliminar(int id){
        Usuarios usuario = buscar(id);
        
        session.getCurrentSession().beginTransaction();
        session.getCurrentSession().delete(usuario);
        session.getCurrentSession().getTransaction().commit();
        
    }
}
