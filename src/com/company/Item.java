package com.company;

import java.io.Serializable;
import java.nio.file.Path;

public abstract class Item implements Serializable {
    private String id;
    private String name;
    private String path;


    public Item(String id,String name, String path){
        System.out.println("ce vrei ????");
        this.id=id;
        this.path=path;
        this.name=name;
    }
    public Item(String id, String path){
        this.id=id;
        this.path=path;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
    public void setId(String id){
        this.id=id;
    }
    public String getName() {
        return name;
    }
    public String getId(){
        return id;
    }
}
