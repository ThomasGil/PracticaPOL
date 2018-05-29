/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import Dao.UsuarioDao;
import Modelo.app.Usuario;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Personal
 */

@Service
public class ServicioUsuarioImpl implements ServicioUsuario{
    
    private UsuarioDao usuarioDao;

    @Transactional
    public void registrar(Usuario usuario) {
        usuarioDao.registrar(usuario);
    }

    @Transactional
    public void editar(Usuario usuario) {
        usuarioDao.editar(usuario);
    }

    @Transactional
    public void eliminar(int id) {
        usuarioDao.eliminar(id);
    }

    @Transactional
    public Usuario buscar(int id) {
        return usuarioDao.buscar(id);
    }
    
}
