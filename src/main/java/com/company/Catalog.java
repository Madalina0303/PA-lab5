package com.company;

import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Catalog implements Serializable {
    private String name;
    private List<Item> lst;
    private String pth;

    public Catalog() {
        lst = new ArrayList<>();
    }

    public Catalog(String pth) {
        try {
            lst = new ArrayList<>();
            // stergem daca exista

            if (Files.exists(Paths.get(pth))) {
                Files.delete(Paths.get(pth));
            }
            //this.pth = Files.createFile(pth);
            this.pth = pth;
        } catch (Exception e) {
            System.err.println(" !!!!!!!!!!!!!Unexpected error");
        }
    }

    public void setLst(List<Item> lst) {
        this.lst = lst;
    }

    public List<Item> getLst() {
        return lst;
    }

    public void add(Item f) {
        try {
            lst.add(f);
        } catch (NullPointerException e) {
            System.err.println("Asta nu se prinde dar nu inteleg ce vrea " + e);
        }
    }

    public void list() {
        for (Item i : lst) {
            System.out.println(i.getName());
        }
    }

    public void play() {
        try {
            Desktop d = Desktop.getDesktop();
            for (Item i : lst) {
                d.open(Paths.get(i.getPath()).toFile());

            }
        } catch (Exception e) {
            System.err.println(e.getMessage());

        }
//        try {
//            Desktop d = Desktop.getDesktop();
//            d.open(Paths.get(pth).toFile());
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//
//        }
    }

    public String getPth() {
        return pth;
    }

    public Item findById(String id) {
        return (Item) lst.stream().filter(d -> d.getId().equals(id)).findFirst().orElse(null);
//        for (Item i : lst) {
//              System.out.println(i.getId());
//            }
    }


    public void save() throws IOException {

        String s = this.pth;

        try (var oos = new ObjectOutputStream(new FileOutputStream(s))) {
            oos.writeObject(this);

        }

    }

    public void load(String path) {

        //  Catalog c = null;
        try (var sursa = new ObjectInputStream(new FileInputStream(path))) {
            Catalog c = (Catalog) sursa.readObject();
            this.pth = c.getPth();
            this.name = c.name;
            this.lst = c.getLst();

        } catch (FileNotFoundException e) {
            System.err.println("Lipsa fisier " + e);
        } catch (IOException e) {
            System.err.println("Eroare " + e);
        } catch (ClassNotFoundException e) {
            System.err.println("Nu s-a gasit clasa " + e);
        }

    }

    public void readComand() {
        System.out.println("add + argument");
        System.out.println("list");
        System.out.println("play");
        System.out.println("save");
        System.out.println("load + argument");
        Scanner s = new Scanner(System.in);
        String arg, arg1;
        String comand = s.next();
        switch (comand) {
            case "add":
                arg = s.next();
                this.add(this.findById(arg));
                break;
            case "list":
                this.list();
                break;
            case "play":
                this.play();
                break;
            case "save":
                try {
                    this.save();
                } catch (IOException e) {
                    System.err.println("Exceptie la save " + e);
                }
                break;
            case "load":
                arg1 = s.next();
                this.load(arg1);
                break;
        }
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


