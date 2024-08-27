package ru.nysanya.start.Model;


import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;


public class ModelVideo {

    private ArrayList<String> arrFolder = new ArrayList<>();
    private ArrayList<String> arrVideo;

    private final String ABSOLUTE_PATH = "A:/Homeserver/start/src/main/resources/mp4";

    public ModelVideo() {

        File dir = new File(ABSOLUTE_PATH);

        for (File file : dir.listFiles()) {
            System.out.println(file.toString().split("mp4")[1].substring(1));
            arrFolder.add(file.toString().split("mp4")[1].substring(1));
        }


    }

    public ArrayList<String> getListFolder() {
        return arrFolder;
    }

    public ArrayList<String> getListVideo(String nameFolder) {
        arrVideo = new ArrayList<>();
        File dir = new File(ABSOLUTE_PATH + "/" + nameFolder);


        for (File file : dir.listFiles()) {
            String str = file.toString().split(nameFolder)[1].substring(1);
            arrVideo.add(str.substring(0, str.length() - 4));
        }


        return arrVideo;
    }


}
