package erick.br.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import erick.br.repository.RepositoryCategoriaLivro;

@Controller
public class ControleLivro {
	@Autowired
	private RepositoryCategoriaLivro repositoryCategoriaLivro; 
 
	@GetMapping(value = {"/livro"})
	public ModelAndView cadLivro() {
		ModelAndView modelAndView = new ModelAndView("view/cadLivro");
		modelAndView.addObject("combCategorias", repositoryCategoriaLivro.carregarCategorias());
		return modelAndView;
	}
}
