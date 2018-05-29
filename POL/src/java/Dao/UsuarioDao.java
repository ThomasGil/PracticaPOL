/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.app.Usuario;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Personal
 */

@Repository
public interface UsuarioDao {
    public void registrar(Usuario usuario);
    public void editar(Usuario usuario);
    public void eliminar(int id);
    public Usuario buscar(int id);
}
