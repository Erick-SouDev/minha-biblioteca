package erick.br.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import erick.br.constantes.ConstMessagemSistem;
import erick.br.model.Categoria;
import erick.br.repository.RepositoryCategoriaLivro;
import jakarta.validation.Valid;

@Controller
public class ControleCategoria {

	@Autowired
	private RepositoryCategoriaLivro servicesCategoria;

	@GetMapping(value = { "/categoria" })
	public ModelAndView paginaCategoria() {
		ModelAndView modelView = new ModelAndView("view/cadCategoria");
		modelView.addObject("categorias", servicesCategoria.findAll(PageRequest.of(0, 5, Sort.by("nomeCategoria"))));
		modelView.addObject("categoria", new Categoria());
		return modelView;
	}

	@PostMapping(value = { "/categoria/salvar" })
	public ModelAndView cadastrarCategoria(@Valid Categoria categoria, BindingResult bindingResult) {

		ModelAndView modelview = new ModelAndView("view/cadCategoria");
		if (bindingResult.hasErrors()) {
			modelview.addObject("categorias", servicesCategoria.findAll(PageRequest.of(0, 5, Sort.by("nomeCategoria"))));
			return modelview;
		}
		if (categoria.getId() == null) {

			modelview.addObject("msg", ConstMessagemSistem.SUCCESS_SAVE);
		} else {
			modelview.addObject("msg", ConstMessagemSistem.SUCCESS_UPDATE);
		}

		Categoria categoriaSalva = servicesCategoria.save(categoria);
		modelview.addObject("categoria", categoriaSalva);
		modelview.addObject("categorias", servicesCategoria.findAll(PageRequest.of(0, 5, Sort.by("nomeCategoria"))));

		return modelview;

	}

	@GetMapping(value = { "/categoria/pagination" })
	public ModelAndView categoriaPagination(@PageableDefault(size = 5) Pageable pagina) {
		ModelAndView modelAndView = new ModelAndView("view/cadCategoria");
		modelAndView.addObject("categorias", servicesCategoria.findAll(pagina));
		modelAndView.addObject("categoria", new Categoria());

		return modelAndView;
	}

	@GetMapping(value = { "/categoria/{id}/editar" })
	public ModelAndView editarCategoria(@PathVariable(value = "id") Long id) {
		ModelAndView modelview = new ModelAndView("view/cadCategoria");
		modelview.addObject("categorias", servicesCategoria.findAll(PageRequest.of(0, 5, Sort.by("nomeCategoria"))));
		modelview.addObject("categoria", servicesCategoria.findById(id).get());
		return modelview;

	}
	
	@GetMapping(value = { "/categoria/{id}/excluir" })
	public ModelAndView excluirCategoria(@PathVariable(value = "id") Long id) {
		ModelAndView modelview = new ModelAndView("view/cadCategoria");
		servicesCategoria.deleteById(id);
		modelview.addObject("msg", ConstMessagemSistem.SUCCESS_DELETE);
		modelview.addObject("categoria", new Categoria());
		modelview.addObject("categorias", servicesCategoria.findAll(PageRequest.of(0, 5, Sort.by("nomeCategoria"))));
		return modelview;

	}

}
