/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.app;

import Modelo.app.Fila;
import Modelo.dao.TareaDao;
import Modelo.hibernate.Tarea;
import java.util.List;
import java.util.Map;
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
public class filasControlador {
    
    private SessionFactory session;
    private TareaDao tareaDao;
    private List<Tarea> tareas;
    
    private filasControlador(){
        session = new NewHibernateUtil().getSessionFactory();
        tareaDao = new TareaDao(session);
    }
    
    
    @RequestMapping("/filas")
    public String filas(Model model){
        model.addAttribute(new Tarea());
        
        tareas = tareaDao.obtenerTareas();  
        
        model.addAttribute("tareas", tareas);
        
        return "filas";
    }
    
    @RequestMapping(value="/agregar", method = RequestMethod.POST)
    public String agregarFilas(Tarea tarea, Model model){
        Map modelMap = model.asMap();
        
        model.addAttribute("test",modelMap.get("id"));
        
        model.addAttribute("test",tareas.get(tarea.getId() - 1).getId());
        return filas(model);
    }
}
