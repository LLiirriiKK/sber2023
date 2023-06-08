public class Quit implements Command{
    @Override
    public String getName() {
        return "quit";
    }

    @Override
    public void exec() {
        System.exit(0);
    }

    @Override
    public void help() {
        System.out.println("Command finishes the program");
    }
}
