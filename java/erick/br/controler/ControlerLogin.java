package erick.br.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControlerLogin {

	
	@GetMapping(value = {"/"})
	public String index() {
		
		
		return "view/login";
	}
}
