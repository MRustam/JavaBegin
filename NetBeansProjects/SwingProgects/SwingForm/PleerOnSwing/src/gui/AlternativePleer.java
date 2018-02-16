package gui;

import fileMp3.FileMp3;
import playList.PlayList;

public class AlternativePleer {
    
    public static void main(String[] args) {
        
        PlayList listMp3 = new PlayList();
        
        FileMp3 file1 = new FileMp3("Evanescence - going under", "User/Desctop/");
        FileMp3 file2 = new FileMp3("Avrillavine - go home", "User/Desctop/");
        FileMp3 file3 = new FileMp3("Within Temptation - frozen", "User/Desctop/");
        FileMp3 file4 = new FileMp3("Skilet - tel me", "User/Desctop/");
        FileMp3 file5 = new FileMp3("Prodigy - medusa path", "User/Desctop/");
        
        listMp3.addMp3(file1);
        listMp3.addMp3(file2);
        listMp3.addMp3(file3);
        listMp3.addMp3(file4);
        listMp3.addMp3(file5);
        
        listMp3.findMp3("Within Temptation - frozen");
    }
}
