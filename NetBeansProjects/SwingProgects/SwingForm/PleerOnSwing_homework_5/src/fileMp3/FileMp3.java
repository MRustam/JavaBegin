package fileMp3;


public class FileMp3 {

    private String name;
    private String path;
    
    
    public FileMp3() {
        
    }
    public FileMp3(String name, String path) {
        this.name = name;
        this.path = path;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "name: " + name + " \n" + "lacation: " + path;
    }
    
    
}
