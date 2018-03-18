package objects;

import java.io.Serializable;
import utils.FileUtils;

public class Mp3 implements Serializable {
    
    private String name;
    private String path;

    public Mp3(String name, String path) {
        this.name = name;
        this.path = path;
    }

    @Override
    public String toString() {
        return FileUtils.getFileNameWithoutExtension(name);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Mp3)) return false;
            
        Mp3 mp3 = (Mp3)obj;
        return path.equals(mp3.getPath());
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }
}
