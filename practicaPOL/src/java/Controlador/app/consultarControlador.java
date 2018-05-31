/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.app;

import Modelo.app.Dependencia;
import Modelo.app.Perfil;
import Modelo.app.Usuario;
import Modelo.dao.PerfilDao;
import Modelo.dao.UsuarioDao;
import Modelo.hibernate.Perfiles;
import Modelo.hibernate.Usuarios;
import java.util.List;
import java.util.Vector;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Personal
 */

@Controller
public class consultarControlador {
    
    private SessionFactory session;
    private UsuarioDao usuarioDao;
    private PerfilDao perfilDao; 
    
    
    public consultarControlador(){
        session = new NewHibernateUtil().getSessionFactory();
        usuarioDao = new UsuarioDao(session);
        perfilDao = new PerfilDao(session);     
    }
    
    @RequestMapping("/consultar")
    public String consultar(Model model){       
        model.addAttribute(new Usuario());
        
        return "/consultar";
    } 
    
    @RequestMapping(value = "/usuario.rd",method = RequestMethod.POST)
    public String acciones(Usuario usuario, Model model , @RequestParam String action){
        
        //
        
        switch(action.toLowerCase()){
		case "consultar":
                    try{
                        Usuario user = obtenerUsuario(usuario,model);
                        if(0 != user.getId()){
                            model.addAttribute("usuarios", user);
                            model.addAttribute("mensajeBien", "Usuario Encontrado");
                        }
                        
                    } catch (Exception e) {
                        model.addAttribute("mensajeError", "Hubo un error intentelo nuevamente");
                    }
                    break;
                    
                case "eliminar":
                    /*try {
                        usuarioDao.eliminar(usuario.getId());
                        perfilDao.eliminar(usuario.getId());
                        model.addAttribute("mensajeBien", "Usuario Eliminado");
                    } catch (Exception e) {
                        model.addAttribute("mensajeError", "Hubo un error intentelo nuevamente");
                    }*/
                        usuarioDao.eliminar(usuario.getId());
                        perfilDao.eliminar(usuario.getId());
                        model.addAttribute("mensajeBien", "Usuario Eliminado");                    
                    break;  
        }
        
        model.addAttribute(new Usuario());
        return "consultar";
    }
    
    public Usuario obtenerUsuario(Usuario usuario, Model model){
        Usuario aux = new Usuario();
        try {
            Usuarios usr = usuarioDao.buscar(usuario.getId());
        
            List<Perfiles> per = perfilDao.obtenerPerfiles();

            aux.setId(usr.getId());
            aux.setFechaNacimiento(usr.getFechaNacimiento());
            aux.setActivo(usr.isActivo());
            aux.setDependencia(Dependencia.valueOf(usr.getDependencia()));

            Perfil[] perfil = new Perfil[per.size()];
            int cont = 0;
            for (int i = 0; i < perfil.length; i++) {
                if(usr.getId() == per.get(i).getId()){
                    perfil[cont] = Perfil.valueOf(per.get(i).getPerfil());
                    cont++;
                }
            }
            aux.setPerfil(perfil);
            aux.setFilas(null);
        } catch (Exception e) {
            model.addAttribute("mensajeError", "No hay un usuario con esa cedula");
        }   
        return aux;
    }
}
