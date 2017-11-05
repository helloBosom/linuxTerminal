import java.util.Scanner;

public class Test {

    private static void main(String[] args) {
        System.out.println(System.getProperties().getProperty("os.name"));
        System.out.println(System.getProperties().getProperty("os.arch"));
        System.out.println(System.getProperties().getProperty("os.version"));
        System.out.println(OrderUtil.location);
        Scanner scan = new Scanner(System.in);
        while (true) {
            OrderUtil.order = scan.next();
            OrderUtil.dealOrder();
        }
    }
}
