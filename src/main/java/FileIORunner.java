import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileIORunner {
    public static String readFromFile(String fileName, boolean addNewLine) throws IOException{
        String returnString = new String();
        Scanner fileReader = null;

        try{
            // this only creates a file object but not an actual file in your directory
            File myFile = new File(fileName);
            if(!myFile.exists()) {
                // createNewFile creates the actual file in your directory. An exception will be thrown if
                // the file already exist so .exists method needs to be use
                myFile.createNewFile();
            }
            fileReader = new Scanner(myFile);
            while(fileReader.hasNextLine()){
                returnString += fileReader.nextLine();
                if(addNewLine){
                    returnString += "\n";
                }
            }
        }catch (Exception e){
            System.out.println("file does not exist!");
            e.printStackTrace();
        } finally {
            if(fileReader != null){
                fileReader.close();
            }
        }
        return returnString;
    }

    public static void writeToFile(String fileName, String text) throws IOException {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName);
            fileWriter.write(text);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            if (fileWriter != null)
                fileWriter.close();
        }
    }

}
