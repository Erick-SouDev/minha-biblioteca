package erick.br.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControleHome {

	@GetMapping(value = "/home")
	public String getHome() {
		return "view/home";
	}
}