package com.company;

import java.io.IOException;

public class SaveComand implements Comand {
    private String path;

    public SaveComand(String path) {
        this.path = path;
    }

    @Override
    public void execute(Catalog c) {
        try {
            c.save();
        } catch (IOException e) {
          System.err.println("Eroare la save "+e);
        }
    }
}