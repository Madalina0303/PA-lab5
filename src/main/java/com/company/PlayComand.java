package com.company;

public class PlayComand implements Comand{
    @Override
    public void execute(Catalog c) {
        c.play();
    }
}
