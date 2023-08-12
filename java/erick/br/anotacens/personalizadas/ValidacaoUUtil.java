package erick.br.anotacens.personalizadas;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidacaoUUtil implements ConstraintValidator<ValidacaoUrl, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
        if(value != null ) {
			String urlValida = "^(https?|ftp)://([A-Za-z0-9.-]+)(:[0-9]+)?(/.*)?$";
			Pattern expressao = Pattern.compile(urlValida);
			Matcher crieterio = expressao.matcher(value);

			return crieterio.matches();
        	
        }
		return false;
	}

}
