package musicprojectlinkservice.music_link_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class YouTubeFetchingException extends RuntimeException {

    public YouTubeFetchingException(String message) {
        super(message);
    }
}
