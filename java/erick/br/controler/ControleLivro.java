package erick.br.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import erick.br.model.Categoria;
import erick.br.model.Livro;
import erick.br.repository.RepositoryCategoriaLivro;
import jakarta.validation.Valid;

@Controller
public class ControleLivro {
	@Autowired
	private RepositoryCategoriaLivro repositoryCategoriaLivro; 
 
	@GetMapping(value = {"/livro"})
	public ModelAndView cadLivro() {
		ModelAndView modelAndView = new ModelAndView("view/cadLivro");
		modelAndView.addObject("combCategorias", repositoryCategoriaLivro.carregarCategorias());
		modelAndView.addObject("livro", new Livro());
		return modelAndView;
	}
	
	
	
	@PostMapping(value = {"/livro/novo"})
	public ModelAndView salvarLivro(@Valid Livro livro  , BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("view/cadLivro");
		if(bindingResult.hasErrors()) {
			modelAndView.addObject("combCategorias", repositoryCategoriaLivro.carregarCategorias());
			return modelAndView;

		}
		modelAndView.addObject("combCategorias", repositoryCategoriaLivro.carregarCategorias());
	
		System.out.println(livro);
		return modelAndView;
	}
	
	
	
}
