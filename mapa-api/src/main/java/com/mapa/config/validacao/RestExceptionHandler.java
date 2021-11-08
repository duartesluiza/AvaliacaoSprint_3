package com.mapa.config.validacao;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// O Hendler eh um interceptador, onde configuro o SPRING p/ sempre que houver um erro em algum metodo,
//de qualquer controller, ele chama automaticamente esse interceptador
 


@Valid
@RestControllerAdvice
public class RestExceptionHandler {

	@Autowired // --> Injeçao
	private MessageSource messageSource; 

	// metodo que fará o tratamento do erro:
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroFormularioDto> handle(MethodArgumentNotValidException exception) {
		List<ErroFormularioDto> dto = new ArrayList<>();

		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		fieldErrors.forEach(e -> {
			String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale()); // p/ pegar msg de erro
			ErroFormularioDto erro = new ErroFormularioDto(e.getField(), mensagem);
			dto.add(erro);
		});

		return dto;
	}
}
