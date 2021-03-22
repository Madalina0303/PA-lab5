package com.company;

import java.nio.file.Path;

public class InvalidData extends Exception {
    public InvalidData(String msg) {
        super(msg);
    }

    public InvalidData(int year) {
        super("Invalid year " + year);
    }

    public InvalidData(Path pt) {
        super("Invalid path " + pt);

    }
    public InvalidData(Exception e){
        super("Invalid ",e);
    }
}
