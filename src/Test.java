import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        System.out.println(System.getProperties().getProperty("os.name"));
        System.out.println(System.getProperties().getProperty("os.arch"));
        System.out.println(System.getProperties().getProperty("os.version"));
        CommandUtil.printLocation();
        Scanner scan = new Scanner(System.in);
        while (true) {
            OrderUtil.order = scan.next();
            OrderUtil.dealOrder();
        }
    }
}
