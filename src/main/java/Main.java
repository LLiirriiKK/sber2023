import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Command> commands = new ArrayList();
        commands.add(new Date());
        commands.add(new Time());
        commands.add(new Pwd());
        commands.add(new Quit());
        while (true){
            String input = scanner.nextLine();
            input = input.trim();
            input = input.replaceAll("\\s+", " ");
            String[] splitInput;
            splitInput = input.split("\\s");
            int i = 0;
            while (!splitInput[0].toLowerCase(Locale.ROOT).equals(commands.get(i).getName())){
                i ++;
            }
            if (splitInput.length == 1){
                commands.get(i).exec();

            }else
                commands.get(i).help();
        }

    }
}
