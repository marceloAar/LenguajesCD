package cl.mar.lenguajes.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import cl.mar.lenguajes.models.Lenguaje;
import cl.mar.lenguajes.services.LenguajeService;

@Controller
public class LenguajeController {

	@Autowired
	LenguajeService lenguajeService;	
	
    //inicio, muestra todos los lenguajes en una tabla, desde la bbdd
	@GetMapping("/languages")
    public String inicio(Model model) {
        List<Lenguaje> lenguajes = lenguajeService.todosLenguajes();
        model.addAttribute("lenguajes", lenguajes);
        return "inicio";
    }
    
    
	//crea un nuevo lenguaje en la bbdd
	@PostMapping("/languages")
	public String creaLenguaje(@Valid @ModelAttribute Lenguaje lenguaje, BindingResult result) {
		
		if (result.hasErrors()) {
            return "redirect:/languages";
        } else {
        	lenguajeService.crearLenguaje(lenguaje);    		
            return "redirect:/languages";
        }
	} 
	
	
	//mostrar un lenguaje con su id
    @GetMapping("/languages/{id}")
	public String mostrarUno(@PathVariable Long id, Model model) {    	
    	model.addAttribute("lenguaje", lenguajeService.buscaUnLenguaje(id));
		return "mostrar";
	}    
   
    
    //editar un lenguaje por su id
    @GetMapping("/languages/edit/{id}")
	public String editar(@PathVariable Long id, Model model) {
		
    	model.addAttribute("lenguaje", lenguajeService.buscaUnLenguaje(id));
		return "edita";
	}
    
	@PostMapping("/languages/{id}")
	public String modifica(@Valid @ModelAttribute Lenguaje lenguaje, BindingResult result) {		
		
		if (result.hasErrors()) {
            return "edita";
        } else {
        	lenguajeService.crearLenguaje(lenguaje);    		
            return "redirect:/languages";
        }		
		
	}
	
	
	//borrar un lenguaje por su id
	@GetMapping("/languages/delete/{id}")
	public String borrar(@PathVariable Long id) {
		lenguajeService.borraLenguaje(id);
		return "redirect:/languages";
	}
	
}
	
	

