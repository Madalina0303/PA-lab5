package com.company;

import java.nio.file.Path;

public abstract class Item {
    private String name;
    private Path path;

    public abstract void setName(String name);

    public abstract void setPath(Path path);
    public   Path getPath(){
        return path;
    }
}
