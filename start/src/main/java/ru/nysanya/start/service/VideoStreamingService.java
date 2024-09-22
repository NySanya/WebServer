package ru.nysanya.start.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import java.awt.image.DataBuffer;
import java.io.InputStream;

@Service
public class VideoStreamingService {
    //fix
    private static final String FORMAT = "classpath:mp4/rikAndMorty/%s.mkv";
    private static final String FORMATS = "classpath:mp4/%s.mkv";

    @Autowired
    private ResourceLoader resourceLoader;

    public Mono<Resource> getVideo(String title, String last) {
        return Mono.fromSupplier(() -> this.resourceLoader.getResource( String.format(FORMATS,  last+"/"+title)));
    }

//    public InputStream getPrev (String s){
//        return getClass().getResourceAsStream("A:\\Homeserver\\start\\src\\main\\resources\\image\\rikAndMorty.jpg");
//    }
}
