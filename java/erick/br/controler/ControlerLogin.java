package erick.br.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControlerLogin {

	
	@RequestMapping("/")
	public String getHome() {
		return "view/home";
	}
}
