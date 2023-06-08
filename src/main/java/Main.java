import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void ErrorUnknownCommand(){
        System.out.println("Unknown command");
        System.out.println("If you want to get a description of the command, you can use parameter 'help'");
    }

    public static void ErrorUnknownParameter(){
        System.out.println("Unknown parameter");
        System.out.println("If you want to get a description of the command, you can use parameter 'help'");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Command> commands = new ArrayList();
        commands.add(new Date());
        commands.add(new Time());
        commands.add(new Pwd());
        commands.add(new Quit());
        while (true){
            System.out.print("? ");
            String input = scanner.nextLine();
            input = input.trim();
            input = input.replaceAll("\\s+", " ");
            String[] splitInput;
            splitInput = input.split("\\s");
            int i = 0;
            while (i < commands.size() && !splitInput[0].toLowerCase(Locale.ROOT).equals(commands.get(i).getName())){
                i ++;
            }


            if (i < commands.size() && splitInput[0].toLowerCase(Locale.ROOT).equals(commands.get(i).getName())){
                if (splitInput.length == 1){
                    commands.get(i).exec();

                }else if (splitInput[1].toLowerCase(Locale.ROOT).equals("help")) {
                    commands.get(i).help();
                }else{
                    ErrorUnknownParameter();
                }
            }
            else {
                ErrorUnknownCommand();
            }
        }

    }
}
