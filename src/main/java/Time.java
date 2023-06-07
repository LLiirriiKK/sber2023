import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Time implements Command{
    @Override
    public String getName() {
        return "time";
    }

    @Override
    public void exec() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime localTime = LocalTime.now();
        String timeString = localTime.format(formatter);


        System.out.println(timeString);
    }

    @Override
    public void help() {
        System.out.println("Command outputs current time");
    }
}
