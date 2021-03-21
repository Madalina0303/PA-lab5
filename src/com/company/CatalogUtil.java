package com.company;

import java.awt.*;
import java.io.*;
import java.nio.file.Paths;

public class CatalogUtil {
    public static void save(Catalog catalog) throws IOException {

        String s = catalog.getPth();
        System.out.println("OFFFF " + s);
       /* try {
            FileOutputStream c = new FileOutputStream(s);
            try {
                ObjectOutputStream oos = new ObjectOutputStream(c);
                oos.writeObject(catalog);
            } catch (IOException e) {
                System.err.println("Vai de vtt " +e);
            }

        } catch (IOException e) {
            System.err.println("esti pe langa " + e);
        }
*/
        try (var oos = new ObjectOutputStream(new FileOutputStream(s))) {
            oos.writeObject(catalog);

        }

    }

    public static void view(Item item) {
        try {
            Desktop d = Desktop.getDesktop();
            d.open(Paths.get(item.getPath()).toFile());

        } catch (Exception e) {
            System.err.println(e.getMessage());

        }

    }

//    public Catalog load(String path) {
//        try (var sursa = new ObjectInputStream(new FileInputStream(path)); // de unde citesc
//             // oos = new ObjectOutputStream(new FileOutputStream(pth)) // unde scriuu
//        ) {
//           // oos.writeObject(sursa);
//            //oos.flush();
//            return sursa;
//        } catch (FileNotFoundException e) {
//            System.err.println("Lipsa fisier " + e);
//        } catch (IOException e) {
//            System.err.println("Eroare " + e);
//        }
//
//    }

    public static Catalog load(String path) {

        Catalog c = null;
        try (var sursa = new ObjectInputStream(new FileInputStream(path))){
            c = (Catalog) sursa.readObject();

        } catch (FileNotFoundException e) {
            System.err.println("Lipsa fisier " + e);
        } catch (IOException e) {
            System.err.println("Eroare " + e);
        } catch (ClassNotFoundException e) {
            System.err.println("Nu s-a gasit clasa " + e);
        }
        return c;

    }
}

