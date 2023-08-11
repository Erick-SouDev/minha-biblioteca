package erick.br.anotacens.personalizadas;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import erick.br.anotacens.personalizadas.util.UrlValidacao;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UrlValidacao.class)
public @interface ValideImageBase64 {

	String text();

	String message() default "Url invalida ";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
