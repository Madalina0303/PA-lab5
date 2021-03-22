package com.company;

import freemarker.cache.FileTemplateLoader;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

import freemarker.template.Configuration;

import java.awt.*;
import java.io.*;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class ReportComand implements Comand {
    @Override
    public void execute(Catalog c) {
        Configuration cfg;
        cfg = new Configuration(new Version(2, 3, 23));

        //  cfg.setClassForTemplateLoading(ReportComand.class,"lib\\templates");
        //cfg.setClassForTemplateLoading(ReportComand.class, "/");
        try {
            cfg.setDirectoryForTemplateLoading(Paths.get("C:\\Users\\40753\\Desktop\\PA-laborator\\lab5\\lib\\templates").toFile());
        } catch (Exception e) {
            System.err.println("eroareeaaa " + e);
        }
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        Map<String, Object> inp = new HashMap<>();
        inp.put("title", "Catalog-continut");
        inp.put("Book", c.getLst().get(0).getPath());
        inp.put("Song", c.getLst().get(1).getPath());
        //c.getLst().get(0).addTag("Book","Carte");
        Template template;
        try {
            template = cfg.getTemplate("content.ftl");
            FileWriter file = new FileWriter("rez.html");
            template.process(inp, file);
            Desktop d = Desktop.getDesktop();
            d.open(Paths.get("rez.html").toFile());
        } catch (IOException e) {
            System.err.println("Eroare pe aici " + e);
        } catch (Exception e) {

            System.err.println("Ceva er ciudata " + e);
        }


    }
}
