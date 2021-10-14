package com.pdfsplitter;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.File;
import java.io.IOException;

class pdfsplitter {
    public static void main(String[] args) throws IOException {
        File folder = new File("C:/Folder/");
        String[] files = folder.list();

        extract(folder, files);
        System.out.println("Done!");
    }

    private static void extract(File folder, String[] files) throws IOException{
        PDDocument docFinal;
        for (String s:files){
            if(s.endsWith(".pdf")){
                docFinal = new PDDocument();

                File file = new File(folder+"/"+s);
                PDDocument doc = PDDocument.load(file);

                PDPage lastPage = doc.getPage(doc.getNumberOfPages() - 2);
                PDPage lastPage2 = doc.getPage(doc.getNumberOfPages() - 1);
                docFinal.addPage(lastPage);
                docFinal.addPage(lastPage2);

                docFinal.save("C:/FolderExtraction/" + s);
                doc.close();
                docFinal.close();
            }
        }
    }
}
