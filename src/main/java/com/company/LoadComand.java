package com.company;

import java.io.IOException;

public class LoadComand implements Comand{
    private String path;
    public LoadComand(String path){
        this.path=path;
    }
    @Override
    public void execute(Catalog c)  {
        c.load(path);
    }
}
