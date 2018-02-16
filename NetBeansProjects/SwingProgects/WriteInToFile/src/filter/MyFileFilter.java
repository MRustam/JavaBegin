package filter;

import java.io.File;
import java.io.FilenameFilter;

public class MyFileFilter implements FilenameFilter {

    private String extension;

    public MyFileFilter(String extension) {
        this.extension = extension;
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith("." + extension);
    }
}
