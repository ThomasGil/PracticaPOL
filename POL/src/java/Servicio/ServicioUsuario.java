/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import Modelo.app.Usuario;

/**
 *
 * @author Personal
 */
public interface ServicioUsuario {
    public void registrar(Usuario usuario);
    public void editar(Usuario usuario);
    public void eliminar(int id);
    public Usuario buscar(int id);
}
