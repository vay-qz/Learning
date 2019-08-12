package pers.vay.designpattern.action.composite.before;

import java.util.ArrayList;
import java.util.List;

public class Folder {

    private List<ImageFile> imageFiles = new ArrayList<>();
    private List<TextFile> textFiles = new ArrayList<>();
    private List<Folder> folders = new ArrayList<>();
    private List<TVFile> tvFiles = new ArrayList<>();

    private String name;

    public Folder(String name) {
        this.name = name;
    }

    public void addImageFile(ImageFile imageFile) {
        imageFiles.add(imageFile);
    }

    public void addTextFiles(TextFile textFile) {
        textFiles.add(textFile);
    }

    public void addFolder(Folder folder) {
        folders.add(folder);
    }

    public void addTVFile(TVFile tvFile) {
        tvFiles.add(tvFile);
    }

}
