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

    @Autowired
    private ResourceLoader resourceLoader;

    public Mono<Resource> getVideo(String title) {
        return Mono.fromSupplier(() -> this.resourceLoader.getResource( String.format(FORMAT, title)));
    }

//    public InputStream getPrev (String s){
//        return getClass().getResourceAsStream("A:\\Homeserver\\start\\src\\main\\resources\\image\\rikAndMorty.jpg");
//    }
}
