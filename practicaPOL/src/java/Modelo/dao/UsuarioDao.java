/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.dao;

import Modelo.app.Usuarios;
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
        session.openSession();
        session.getCurrentSession().beginTransaction();
        session.getCurrentSession().save(usuario);
        session.getCurrentSession().getTransaction().commit();
        session.close();
    }
    
    public void actualizar(Usuarios usuario){
        session.openSession();
        session.getCurrentSession().beginTransaction();
        session.getCurrentSession().update(usuario);
        session.getCurrentSession().getTransaction().commit();
        session.close();
    }
    
    public Usuarios buscar(int id){
        Usuarios usuario;
        session.openSession();
        session.getCurrentSession().beginTransaction();
        usuario = (Usuarios) session.getCurrentSession().get(Usuarios.class, id);
        session.getCurrentSession().getTransaction().commit();
        session.close();
        
        return usuario;
    }
    
    public void eliminar(int id){
        Usuarios usuario = buscar(id);
        session.openSession();
        session.getCurrentSession().beginTransaction();
        session.getCurrentSession().delete(usuario);
        session.getCurrentSession().getTransaction().commit();
        session.close();}
}
