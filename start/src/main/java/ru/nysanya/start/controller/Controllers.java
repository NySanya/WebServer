package ru.nysanya.start.controller;

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

    @Autowired
    private VideoStreamingService service;


//    @GetMapping(value = "img/{title}")
//    public byte[] getPrev(@PathVariable String title) throws IOException {
//        return IOUtils.toByteArray(service.getPrev(title));
//    }

    @GetMapping(value = "video/{title}", produces = "video/mkv")
    public Mono<Resource> getVideos(@PathVariable String title) {
        return service.getVideo(title);
    }

    @GetMapping(value = "/{folderName}")
    public ModelAndView getPage(@PathVariable String folderName) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("listNameVideo", mv.getListVideo(folderName));
        modelAndView.addObject("folderName", folderName);
        modelAndView.setViewName("pageVideo");
        return modelAndView;

    }


//<video th:src="video/${videoName}" width="300px" height="250" controls preload="metadata"></video>

    @RequestMapping("/")
    public ModelAndView indexHTml() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("listNameFolder", mv.getListFolder());
        return modelAndView;
    }
}
