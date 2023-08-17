package erick.br.controler;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.domain.Pageable;

import erick.br.constantes.ConstMessagemSistem;
import erick.br.model.Categoria;
import erick.br.model.Livro;
import erick.br.repository.RepositoryCategoriaLivro;
import erick.br.repository.RepositoryLivro;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.websocket.server.PathParam;

@Controller
public class ControleLivro {
	@Autowired
	private RepositoryCategoriaLivro repositoryCategoriaLivro;
	@Autowired
	private RepositoryLivro repositoryLivro;

	@GetMapping(value = { "/livro" })
	public ModelAndView cadLivro() {
		ModelAndView modelAndView = new ModelAndView("view/cadLivro");
		modelAndView.addObject("combCategorias", repositoryCategoriaLivro.carregarCategorias());
		modelAndView.addObject("paginas", repositoryLivro.findAll(PageRequest.of(0, 10, Sort.by("titulo"))));
		modelAndView.addObject("livro", new Livro());
		return modelAndView;
	}

	@PostMapping(value = { "/livro/novo" })
	public ModelAndView salvarLivro(@Valid Livro livro, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("view/cadLivro");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("combCategorias", repositoryCategoriaLivro.carregarCategorias());
			modelAndView.addObject("paginas", repositoryLivro.findAll(PageRequest.of(0, 10, Sort.by("titulo"))));
			return modelAndView;

		}

		if (livro.getId() == null) {
			// e um novo livro
			modelAndView.addObject("msg", ConstMessagemSistem.SUCCESS_SAVE);
		} else {
			modelAndView.addObject("msg", ConstMessagemSistem.SUCCESS_UPDATE);

		}
		Livro novoLivro = repositoryLivro.save(livro);
		modelAndView.addObject("livro", novoLivro);
		modelAndView.addObject("combCategorias", repositoryCategoriaLivro.carregarCategorias());
		modelAndView.addObject("paginas", repositoryLivro.findAll(PageRequest.of(0, 10, Sort.by("titulo"))));

		return modelAndView;
	}

	@GetMapping(value = { "/livro/pagination" })
	public ModelAndView livroPagination(@PageableDefault(page = 10) Pageable pagina) {
		ModelAndView modelAndView = new ModelAndView("view/cadLivro");

		modelAndView.addObject("paginas", repositoryLivro.findAll(pagina));
		modelAndView.addObject("combCategorias", repositoryCategoriaLivro.carregarCategorias());
		modelAndView.addObject("livro", new Livro());
		return modelAndView;
	}

	@GetMapping(value = { "/livro/{id}/editar" })
	public ModelAndView editarLivro(@PathVariable(value = "id") String id) {
		ModelAndView modelAndView = new ModelAndView("view/cadLivro");

		Livro livro = repositoryLivro.getById(Long.parseLong(id));
		System.out.println(livro.toString());
		modelAndView.addObject("livro", new Livro());
		modelAndView.addObject("livro", livro);
		modelAndView.addObject("combCategorias", repositoryCategoriaLivro.carregarCategorias());
		modelAndView.addObject("paginas", repositoryLivro.findAll(PageRequest.of(0, 10, Sort.by("titulo"))));
		return modelAndView;

	}

	@PostMapping(value = { "/livro/consultar" }  )
	public ModelAndView pesquisarLivro(@RequestParam("tituloPesquisado") String tituloPesquisado,
		 @PageableDefault(size = 10)	Pageable pageable  ) {
		ModelAndView modelview = new ModelAndView("view/cadLivro");
		
		Page<Livro> page = repositoryLivro.findPagableLivro(tituloPesquisado, pageable);
	
		System.out.println(page.getTotalPages());
		
		
		modelview.addObject("paginas", page);

		modelview.addObject("tituloPesquisado", tituloPesquisado);
		modelview.addObject("combCategorias", repositoryCategoriaLivro.carregarCategorias());
		modelview.addObject("livro", new Livro());
		return modelview;

	}

}
