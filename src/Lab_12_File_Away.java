import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class Lab_12_File_Away {

    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        Scanner inFile;
        String line;
        int lineCounter = 0;
        int wordCounter = 0;
        int characterCounter = 0;
        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src");
        // set the chooser to the project src directory
        chooser.setCurrentDirectory(target.toFile());

        try  // Code that might trigger the exception goes here
        {
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                target = chooser.getSelectedFile().toPath();  // this is a File object not a String filename
                inFile = new Scanner(target);

                System.out.println("\nSUMMARY REPORT OF THE FILE:\n");
                System.out.println("1) File Name: " + target);

                while (inFile.hasNextLine()) {
                    lineCounter++;
                    line = inFile.nextLine();
                    wordCounter += line.split(" ").length;
                    characterCounter += line.split("").length;
                }
                System.out.println("2) Number of Lines in the File: " + lineCounter);
                System.out.println("3) Number of Words in the File: " + wordCounter);
                System.out.println("4) Number of Characters in the File: " + characterCounter);

                inFile.close();
            } else   // User did not pick a file, closed the chooser
            {
                System.out.println("Sorry, you must select a file! Termininating!");
                System.exit(0);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found Error");
            e.printStackTrace();
        } catch (IOException e) // code to handle this exception
        {
            System.out.println("IOException Error");
            e.printStackTrace();
        }
    }

}