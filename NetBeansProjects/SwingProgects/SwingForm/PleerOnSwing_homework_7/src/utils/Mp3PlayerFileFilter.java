package utils;

import java.io.File;
import javax.swing.filechooser.FileFilter;



public class Mp3PlayerFileFilter extends FileFilter {

    private String extensionFile;
    private String descriptionFile;

    public Mp3PlayerFileFilter(String extensionFile, String descriptionFile) {
        this.extensionFile = extensionFile;
        this.descriptionFile = descriptionFile;
    }

    @Override
    public boolean accept(File f) {

        return f.isDirectory() || f.getAbsolutePath().toLowerCase().endsWith(extensionFile);

    }

    @Override
    public String getDescription() {

        return descriptionFile + " (*." + extensionFile + ")";

    }

    
    
}
