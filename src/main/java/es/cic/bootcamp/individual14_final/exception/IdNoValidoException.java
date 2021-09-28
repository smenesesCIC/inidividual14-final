package es.cic.bootcamp.individual14_final.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class IdNoValidoException extends RuntimeException {

	public IdNoValidoException(String message) {
	}


}
