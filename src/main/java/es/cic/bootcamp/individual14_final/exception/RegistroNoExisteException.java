package es.cic.bootcamp.individual14_final.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class RegistroNoExisteException extends RuntimeException {
	
	public RegistroNoExisteException(String message) {
		super(message);
	}
	
}
