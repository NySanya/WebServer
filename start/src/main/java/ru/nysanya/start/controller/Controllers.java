package ru.nysanya.start.controller;

import lombok.NonNull;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import reactor.core.publisher.Mono;
import ru.nysanya.start.Model.ModelVideo;
import ru.nysanya.start.service.VideoStreamingService;

import java.awt.image.DataBuffer;
import java.io.IOException;


@RestController
public class Controllers {
    static final String INDEX_PAGE = "index";
    static final ModelVideo mv = new ModelVideo();

    static String last ="";
    @Autowired
    private VideoStreamingService service;


//    @GetMapping(value = "img/{title}")
//    public byte[] getPrev(@PathVariable String title) throws IOException {
//        return IOUtils.toByteArray(service.getPrev(title));
//    }

    @GetMapping(value = "pag/video/{title}", produces = "video/mkv")
    public Mono<Resource> getVideos(@PathVariable String title) {
        return service.getVideo(title, last);
    }

    @GetMapping(value = "pag/{folderName}")
    public ModelAndView getPage(@PathVariable (required = false) String folderName) {
        ModelAndView modelAndView = new ModelAndView();
        if(folderName !=null) {
            modelAndView.addObject("listNameVideo", mv.getListVideo(folderName));
            last = folderName;
            modelAndView.addObject("folderName", folderName);
        }
        modelAndView.setViewName("pageVideo");
        return modelAndView;

    }


//<video th:src="video/${videoName}" width="300px" height="250" controls preload="metadata"></video>

    @RequestMapping(value ="/**")
    public ModelAndView indexHTml() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("listNameFolder", mv.getListFolder());
        return modelAndView;
    }
}
