package erick.br.controler;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControlerLogin {

	
	@GetMapping(value = {"/login"})
	public String pageLogin() {
		
		
		return "login";
	}
}
