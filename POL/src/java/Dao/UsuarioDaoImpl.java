/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.app.Usuario;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Personal
 */
public class UsuarioDaoImpl implements UsuarioDao{
    
    @Autowired
    private SessionFactory session;

    @Override
    public void registrar(Usuario usuario) {
        session.getCurrentSession().save(usuario);
    }

    @Override
    public void editar(Usuario usuario) {
        session.getCurrentSession().update(usuario);
    }

    @Override
    public void eliminar(int id) {
        session.getCurrentSession().delete(buscar(id));
    }

    @Override
    public Usuario buscar(int id) {
        return (Usuario) session.getCurrentSession().get(Usuario.class, id);
    }
    
}
