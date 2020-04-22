package musicprojectlinkservice.music_link_service.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class LinkMetaResponse {

    private String title;
    private String description;
    private String duration;
    private String source;
    private String imagePath;

}
