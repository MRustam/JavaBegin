package start;

import filter.MyFileFilter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Start {

    public static void main(String[] args) {

//        String path = "./src/files/text2.txt";
//        String msg = "Test file write with buffer ";
//
//        try (BufferedWriter bf = new BufferedWriter(new FileWriter(path, true))) {
//
//            bf.write(msg);
//            bf.flush();
//            System.out.println("Done.");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        
        
// Find file with .txt extension.
//        File dir = new File("./src/files/");
//
//        MyFileFilter filter = new MyFileFilter("mp4");
//        
//        for (String fileType : dir.list(filter)) {
//            System.out.println(fileType);
//        }



// Show all files with statistic by count ech.
        
        File dir = new File("/Users/rustam/Library");

        Set<String> extensionList = new HashSet<>();
        
        for (String fileName : dir.list()) {
            
            File file = new File(dir.getAbsolutePath() + "/" + fileName);
            
            int i = fileName.lastIndexOf(".");
            
            if (file.isFile() && i != -1) {
                extensionList.add(fileName.substring(i + 1, fileName.length()).toLowerCase());
            }
        }
        
        for (String extension : extensionList) {
            
            MyFileFilter filter = new MyFileFilter(extension);
            
            System.out.println("." + extension + ": " + dir.listFiles(filter).length);
        }
    }
}
