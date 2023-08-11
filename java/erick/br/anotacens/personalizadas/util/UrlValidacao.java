package erick.br.anotacens.personalizadas.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import erick.br.anotacens.personalizadas.ValideImageBase64;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UrlValidacao implements ConstraintValidator<ValideImageBase64, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub

		String regexBase64 = "data:image/(png|jpeg|jpg|gif);base64,[A-Za-z0-9+/]+={0,2}";
		Pattern expressao = Pattern.compile(regexBase64);
		Matcher crieterio = expressao.matcher(value);
	
		return crieterio.matches();
	}

}
