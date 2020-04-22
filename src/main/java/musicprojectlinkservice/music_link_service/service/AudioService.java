package musicprojectlinkservice.music_link_service.service;

import musicprojectlinkservice.music_link_service.exception.YouTubeFetchingException;
import musicprojectlinkservice.music_link_service.model.LinkMetaResponse;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;


public class AudioService {

    public LinkMetaResponse getSongInfo(String link) {

        try {
            Connection connection = Jsoup.connect(link).timeout(3000);
            Document document = connection.get();
            LinkMetaResponse.LinkMetaResponseBuilder builder = LinkMetaResponse.builder();


            String time = document.select("meta[itemprop=duration]").attr("content");


            builder.title(document.select("meta[name=title]").attr("content"))
                    .description(document.select("meta[name=description]").attr("content"))
                    .duration(time.substring(time.indexOf("T") + 1, time.indexOf("M")) + ":" + time.substring(time.indexOf("M") + 1, time.indexOf("S")) + " MIN")
                    .source("YouTube");

            Elements hrefs = document.select("link[itemprop=thumbnailUrl]");
            String imagePath = "";

            for (Element headline : hrefs) {
                imagePath = headline.absUrl("href");
            }

            if(!imagePath.equals("")) builder.imagePath(imagePath);

            return builder.build();
        } catch (IOException e) {
           throw new YouTubeFetchingException("Cannot read file");
        }
    }
}
