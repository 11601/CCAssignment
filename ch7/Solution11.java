import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Hakim on 10/26/15.
 */

class File {
    private boolean isDirectory;
    private int size;
    private String name;
    private String accessRights;
    private Set<String> fileNames;
    private Set<File> files;
    private Map<String, File> nameFile;
    private String content;

    public File(String name, boolean isDirectory, String content){

    }

    public void updateContent(){

    }

    public void updateSize(){

    }

    public void rename(String newName){

    }

    public String pwd(){

    }

    public String getAccessRights(){};
    public void updateAccessStrings(){};

    public void writeContent(String con){
        content = con;
    }

    public boolean mkdir(String directoryName){
        if (fileNames.contains(directoryName)){
            return false;
        }
        File dir = new File(directoryName,true);
        fileNames.add(directoryName);
        files.add(dir);
        return true;
    }

    public boolean touch(String fileName){
        if (fileNames.contains(fileName)){
            return false;
        }
        else{
            files.add(new File(fileName,false));
            fileNames.add(fileName);
            return true;
        }
    }

    public void ls(){
        for (String fileName : fileNames){
            System.out.println(fileName);
        }
    }

    public boolean rm(String fileName){
        if (!fileNames.contains(fileName)){
            return false;
        }
        fileNames.remove(fileName);
        files.remove(nameFile.get(fileName));
        return true;
    }

    public int computeSize(String con){

    }
}




public class Solution11 {
}
