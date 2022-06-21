package idat.edu.pe.daa2.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import idat.edu.pe.daa2.jpa.modelo.Pelicula;
import idat.edu.pe.daa2.servicios.PeliculasServicio;

@Controller
@RequestMapping("/peliculas")
public class PeliculaWebController {

	@Autowired
	private PeliculasServicio servicio;
	
	@RequestMapping("/listarTodo")
	public String listarPeliculas(Model model) {
		List<Pelicula> listaPeliculas = servicio.buscarTodo();
		
		System.out.println("LISTA DE PELICULAS : " + listaPeliculas);
		
		model.addAttribute("listaPeliculas", listaPeliculas);
		return "/moduloPeliculas/listarTodo";
	}
	

	@RequestMapping("/nuevo")
	public String nuevaPelicula(Model model) {
		Pelicula pelicula = new Pelicula();
		model.addAttribute("pelicula", pelicula);
		return "/moduloPeliculas/nuevaPelicula";
		
	}
	
	@RequestMapping(value = "/guardar" , method = RequestMethod.POST)
	public String crearPelicula(@ModelAttribute("pelicula") Pelicula pelicula) {
		    servicio.crear(pelicula);
		    return "redirect:/peliculas/listarTodo";
	
	}
	
	
	
	
}