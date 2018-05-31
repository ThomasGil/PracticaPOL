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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    
    @RequestMapping(value = "/consulta",method = RequestMethod.POST)
    public String consultar(Usuario usuario, Model model){
        
        Usuarios usr = usuarioDao.buscar(usuario.getId());
        
        List<Perfiles> per = perfilDao.obtenerPerfiles();
        
        usuario.setId(usr.getId());
        usuario.setFechaNacimiento(usr.getFechaNacimiento());
        usuario.setActivo(usr.isActivo());
        usuario.setDependencia(Dependencia.valueOf(usr.getDependencia()));
        
        Perfil[] perfil = new Perfil[per.size()];
        int cont = 0;
        for (int i = 0; i < perfil.length; i++) {
            if(usr.getId() == per.get(i).getId()){
                perfil[cont] = Perfil.valueOf(per.get(i).getPerfil());
                cont++;
            }
        }
        usuario.setPerfil(perfil);
        usuario.setFilas(null);
        
        /*
        model.addAttribute("test", "" + perfil[0] + perfil[1]);
        model.addAttribute("test0", per.get(0).getPerfil());
        model.addAttribute("test1", per.get(1).getPerfil());
        model.addAttribute("test2", per.get(2).getPerfil());
        */
        model.addAttribute("usuarios", usuario);
        
        return "consultar";
    }
}
