public class Pwd implements Command{
    @Override
    public String getName() {
        return "pwd";
    }

    @Override
    public void exec() {
        System.out.println(System.getProperty("user.dir"));
    }

    @Override
    public void help() {
        System.out.println("Command outputs current directory");
    }
}
