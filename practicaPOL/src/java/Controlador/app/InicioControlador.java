/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.app;

import java.util.List;

import Modelo.app.Dependencia;
import Modelo.app.Fila;
import Modelo.app.Perfil;
import Modelo.app.Usuario;
import Modelo.dao.PerfilDao;
import Modelo.dao.TareaDao;
import Modelo.dao.UsuarioDao;
import Modelo.hibernate.Perfiles;
import Modelo.hibernate.Tarea;
import Modelo.hibernate.Usuarios;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Personal
 */

@Controller
public class InicioControlador {
    
    private SessionFactory session;
    private UsuarioDao usuarioDao;
    private PerfilDao perfilDao; 
    
    
    public InicioControlador(){
        session = new NewHibernateUtil().getSessionFactory();
        usuarioDao = new UsuarioDao(session);
        perfilDao = new PerfilDao(session);     
    }
    
    @RequestMapping("/")
    public String Inicio(Model model){
        
        model.addAttribute("dependencias", Dependencia.values());
        model.addAttribute("Perfiles", Perfil.values());
        model.addAttribute(new Usuario());
        
        return "inicio";
    } 
    
    @RequestMapping(value = "/usuario.cu",method = RequestMethod.POST)
    public String acciones(Usuario usuario, Model model , @RequestParam String action){
        Usuarios user = new Usuarios(usuario.getId(), usuario.getFechaNacimiento(),
                                     usuario.isActivo(), usuario.getDependencia().toString());
        Perfil[] perfil = usuario.getPerfil();
        
        switch(action.toLowerCase()){
		case "registrar":
                    try {
                        usuarioDao.registrar(user);
                        perfilDao.registrar(usuario.getId(), perfil);
                        model.addAttribute("mensajeBien", "Usuario Registrado");
                        model.addAttribute("usuarios", usuario);

                    } catch (Exception e) {
                        model.addAttribute("mensajeError", "Hubo un error intentelo nuevamente");
                    }
                    break;
                    
                case "actualizar":
                    try {
                        usuarioDao.actualizar(user);
                    
                        perfilDao.eliminar(usuario.getId());
                        perfilDao.registrar(usuario.getId(), perfil);
                        
                        model.addAttribute("mensajeBien", "Usuario Actualizado");
                        return "inicio";
 
                    } catch (Exception e) {
                        model.addAttribute("mensajeError", "Hubo un error intentelo nuevamente");
                    }

                    break;  
        }
        
        model.addAttribute("dependencias", Dependencia.values());
        model.addAttribute("Perfiles", Perfil.values());     
        model.addAttribute(new Usuario());
        
        return "consultar";
    }  
    
}
