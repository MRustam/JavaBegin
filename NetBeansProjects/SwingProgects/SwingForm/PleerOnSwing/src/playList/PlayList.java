package playList;

import fileMp3.FileMp3;
import java.util.ArrayList;
import java.util.List;

public class PlayList {
    
    
    
    private List<FileMp3> mp3List = new ArrayList<FileMp3>();

    public List<FileMp3> getMp3List() {
        return mp3List;
    }
    
    
    
    public void addMp3(FileMp3 mp3) {
        mp3List.add(mp3);
    }
    
    public void findMp3(String name) {
        for (FileMp3 mp3 : mp3List) {
            if (mp3.getName().equals(name)) {
                System.out.println(String.valueOf(mp3));
            }
        }
    }
}
