/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servicios.app;

import Controlador.app.NewHibernateUtil;
import Modelo.app.Dependencia;
import Modelo.app.Perfil;
import Modelo.app.Usuario;
import Modelo.dao.PerfilDao;
import Modelo.dao.UsuarioDao;
import Modelo.hibernate.Usuarios;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.hibernate.SessionFactory;

/**
 *
 * @author Personal
 */

/*
@WebService
public class UsuarioService {
    
    private SessionFactory session;
    private PerfilDao perfilDao;
    private UsuarioDao usuarioDao;
    
    public UsuarioService(){
        session = new NewHibernateUtil().getSessionFactory();
        usuarioDao = new UsuarioDao(session);
        perfilDao = new PerfilDao(session);
    
    }
    
    @WebMethod
    public void registrar(Usuario usuario){
        usuarioDao.registrar(usuario.getUsuario(usuario));
        perfilDao.registrar(usuario.getId(), usuario.getPerfil());
    }
    
    @WebMethod
    public void actualizar(Usuario usuario){
        usuarioDao.actualizar(usuario.getUsuario(usuario));                    
        perfilDao.eliminar(usuario.getId());
        perfilDao.registrar(usuario.getId(), usuario.getPerfil());
    }
    
    @WebMethod
    public void eliminar(int id){
        usuarioDao.eliminar(id);
        perfilDao.eliminar(id);
    }
    
    @WebMethod
    public Usuario buscar(int id){
        Usuario user = null;
        Usuarios aux = usuarioDao.buscar(id);
        Perfil [] per = perfilDao.obtenerPerfilesUsuario(id);
        
        user.setId(id);
        user.setFechaNacimiento(aux.getFechaNacimiento());
        user.setActivo(aux.isActivo());
        user.setDependencia(Dependencia.valueOf(aux.getDependencia()));
        user.setPerfil(per);
        
        return user;
    }
}

*/
