package ch.ibw.io;

import java.io.File;
public class FileTest {
    public static void main(String[] args) {
        
        // Create file object for directory
        File directory = new File("myDirectory");
        System.out.println("Is Directory: "+directory.isDirectory()
                + ", absolute path: "+directory.getAbsolutePath());

        // List files in the directory
        for(File file: directory.listFiles()) {
            System.out.println("File in directory: "+file.getName());
        }

        // create file object
        File songsFile = new File(directory, "songs.txt");
        // check if file exists
        System.out.println("Datei existiert: "+songsFile.exists());
    }
}
