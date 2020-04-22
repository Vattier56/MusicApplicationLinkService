package musicprojectlinkservice.music_link_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MissingParameterException extends RuntimeException {

    public MissingParameterException(String message) {
        super(message);
    }
}
