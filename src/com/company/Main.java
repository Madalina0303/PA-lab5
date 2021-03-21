package com.company;

import javax.xml.catalog.CatalogFeatures;
import java.io.IOException;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {
        String pathC = "C:\\Users\\40753\\Desktop\\PA-laborator\\lab5\\catalog2.ser";
        //System.out.println(Paths.get(pathC));
        // Catalog c = new Catalog(Paths.get(pathC));
        Catalog c = new Catalog(pathC);
        String pathB = "C:\\Users\\40753\\Downloads\\lexyacc.pdf";
        //Book b = new Book(Paths.get(pathB));
        Book b = new Book("bestBook",pathB);

        String pathS = "D:\\an 1\\semestrul 1\\engleza\\joc.mp3";

       // Song s = new Song(Paths.get(pathS));
        Song s = new Song("bestSong",pathS);

        c.add(b);
        c.add(s);
        System.out.println("song si book uite ce id au " +s.getId()+b.getId());
        CatalogUtil.save(c);
        Catalog test= CatalogUtil.load("C:\\Users\\40753\\Desktop\\PA-laborator\\lab5\\catalog2.ser");
      //  if(test!=null)
       // test.findById("bestSong");
        CatalogUtil.view(test.findById("bestSong"));
    }
}
