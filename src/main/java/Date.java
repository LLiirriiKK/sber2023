import java.time.LocalDate;

public class Date implements Command{
    @Override
    public String getName() {
        return "date";
    }

    @Override
    public void exec() {
        LocalDate curDate = LocalDate.now();
        String currentDate = curDate.toString();
        System.out.println(currentDate);
    }

    @Override
    public void help() {
        System.out.println("Command outputs current date");

    }

}
