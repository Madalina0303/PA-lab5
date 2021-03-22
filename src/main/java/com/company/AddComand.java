package com.company;

public class AddComand implements Comand{
    private Item item;
    public AddComand(Item item){
        this.item=item;
    }
    @Override
    public void execute(Catalog c) {
        c.add(item);
    }
}
