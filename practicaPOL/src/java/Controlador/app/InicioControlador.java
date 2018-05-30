/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.app;

import Modelo.app.Usuarios;
import Modelo.dao.UsuarioDao;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Personal
 */

@Controller
public class InicioControlador {
    
    private SessionFactory session;
    private UsuarioDao usuarioDao;
    
    public InicioControlador(){
        session = new NewHibernateUtil().getSessionFactory();
        usuarioDao = new UsuarioDao(session);
    }
    
    @RequestMapping("/")
    public String Inicio(Model model){
        model.addAttribute(new Usuarios());
        return "inicio";
    } 
    
    @RequestMapping(value = "/registrar", method = RequestMethod.POST)
    public String Registrar(Usuarios usuario, Model model){
        usuario.setActivo(true);
        usuarioDao.eliminar(usuario.getId());
        Usuarios result = usuarioDao.buscar(usuario.getId());
        model.addAttribute("mensajeBien", "" + result.getId() + ", " + result.getFechaNacimiento());
        return "inicio";
    }
    
}
