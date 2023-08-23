package erick.br.anotacoens.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidationUrlUtil implements ConstraintValidator<UrlValidation, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub

		String regexUrl = "^(https?|ftp)://([A-Za-z0-9.-]+)(:[0-9]+)?(/.*)?$";
		Pattern expressao = Pattern.compile(regexUrl);
		Matcher criterio = expressao.matcher(value);

		return criterio.matches();

	}

}
