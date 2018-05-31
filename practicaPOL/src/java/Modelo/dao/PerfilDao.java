/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.dao;



import Modelo.app.Perfil;
import Modelo.hibernate.Perfiles;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

/**
 *
 * @author Personal
 */
public class PerfilDao {
    private SessionFactory session;
    
    public PerfilDao(SessionFactory session){
        this.session = session;
    }
    
    public void registrar(Perfiles perfil){
        session.getCurrentSession().beginTransaction();
        session.getCurrentSession().save(perfil);
        session.getCurrentSession().getTransaction().commit();
    }
    
    public void registrar(int id, Perfil[] perfiles){
        if(perfiles.length != 0 ){
            for (Perfil perfil : perfiles) {
                Perfiles aux = new Perfiles(id, perfil.toString());
                    session.getCurrentSession().beginTransaction();
                    session.getCurrentSession().save(aux);
                    session.getCurrentSession().getTransaction().commit();
            }
        }
    }
    
    public void actualizar(Perfiles perfil){
        
        session.getCurrentSession().beginTransaction();
        session.getCurrentSession().update(perfil);
        session.getCurrentSession().getTransaction().commit();
        
    }
    
    public void eliminar(int id){
        String hql = "DELETE FROM Perfiles WHERE id = "+id+"";
        session.getCurrentSession().beginTransaction();
        Query query = session.getCurrentSession().createSQLQuery(hql);
        query.executeUpdate();
        session.getCurrentSession().getTransaction().commit();
    }
    
    public List<Perfiles> obtenerPerfiles(){
        
        List<Perfiles> perfiles;
        session.getCurrentSession().beginTransaction();
        perfiles = session.getCurrentSession().createQuery("from Perfiles").list();
        session.getCurrentSession().getTransaction();
    
        return perfiles;
    }
}
