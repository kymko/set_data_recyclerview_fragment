package com.example.fragmenthomework;

import java.io.Serializable;

public class dataModel implements Serializable {

    int image;
    String header, desc;

    public dataModel(int image, String header, String desc) {
        this.image = image;
        this.header = header;
        this.desc = desc;
    }

    public int getImage() {
        return image;
    }
    public String getHeader() {
        return header;
    }
    public String getDesc() {
        return desc;
    }
}
