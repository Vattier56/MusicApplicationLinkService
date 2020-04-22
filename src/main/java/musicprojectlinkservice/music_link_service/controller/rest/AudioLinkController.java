package musicprojectlinkservice.music_link_service.controller.rest;

import musicprojectlinkservice.music_link_service.exception.MissingParameterException;
import musicprojectlinkservice.music_link_service.service.AudioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AudioLinkController {


    @PostMapping("/youtube-service")
    public ResponseEntity retrieveYouTubeMetaInfo(String link) {

        if(link.isEmpty())
            throw new MissingParameterException("URL not found");

        AudioService audioService = new AudioService();

        return ResponseEntity.ok(audioService.getSongInfo(link));
    }
}
