package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Catalog {
    private List<Item> lst;

    public Catalog() {
        lst = new ArrayList<>();
    }

    public void setLst(List<Item> lst) {
        this.lst = lst;
    }

    public List<Item> getLst() {
        return lst;
    }

    public void add(Item f) {
        lst.add(f);
    }

}
    /* private List<File> lst;

    public Catalog() {
        lst = new ArrayList<>();
    }

    public Catalog(List<File> lst) {
        this.lst = lst;
    }

    public void add(File f) {
        lst.add(f);
    }

    public void list() throws FileNotFoundException {
        for (File f : lst) {
            Scanner in = new Scanner(f);
            while (in.hasNextLine()) {
                System.out.println(in.nextLine());
            }

        }
    }
*/


