package br.com.carlos.mangaorganizer.validations;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.carlos.mangaorganizer.models.Manga;

public class MangaValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Manga.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Manga manga = (Manga) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "status", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "publicationDate", "field.required");

		if (manga.getChapters() == null) {
			errors.rejectValue("chapters", "field.required");
			
		} else if (manga.getChapters().intValue() <= 0) {
			errors.rejectValue("chapters", "field.value.invalid");
			
		}
	
	}

}
