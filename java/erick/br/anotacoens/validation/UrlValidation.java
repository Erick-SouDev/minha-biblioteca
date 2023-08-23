package erick.br.anotacoens.validation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidationUrlUtil.class)
public @interface UrlValidation {

	String text();

	String message() default "Url invalida ";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
