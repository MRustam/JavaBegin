package utils;

import java.io.File;
import java.io.FileFilter;
import javax.swing.JFileChooser;

public class FileUtils {

    public static void setFileFilter(JFileChooser jfc, PlayerFileFilter pff) {

        jfc.removeChoosableFileFilter(jfc.getFileFilter());
        jfc.setFileFilter(pff);
        jfc.setSelectedFile(new File(""));
        
    }
    
}
