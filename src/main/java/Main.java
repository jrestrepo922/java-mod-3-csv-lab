import java.io.IOException;
import java.time.Period;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // your code here
        try(Scanner scanner = new Scanner(System.in)){

                System.out.println("=========== Welcome to add people to a csv ==============");
                String optionsType = "0";
                //ask if a new file or an existing file
                String newOrRestoreFIle = PersonService.newOrRestoreFile(scanner);
                while(!optionsType.equals("3")){
                    // ask what type of services
                    optionsType = PersonService.provideOptionsType(scanner);
                    if(optionsType.equals("1")){
                        PersonService.addPerson(scanner, newOrRestoreFIle);
                    } else if(optionsType.equals("2")){
                        PersonService.printCurrentPeople(newOrRestoreFIle, scanner);
                    }
                }
                System.out.println("System was exited");
        }catch (IOException ioException){
            ioException.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
