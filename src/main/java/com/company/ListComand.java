package com.company;

public class ListComand implements Comand{
    @Override
    public void execute(Catalog c) {
        c.list();
    }
}
