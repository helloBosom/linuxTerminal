import java.util.Scanner;

public class OptionUtil {
    public static void execute(String command, String option) {
        switch (command) {
            case "cd":
                switch (option) {
                    case "/":
                        OrderUtil.back = option;
                        returnRoot();
                        break;
                    case "~":
                        OrderUtil.back = option;
                        returnRootHome();
                        break;
                    case "-":
                        OrderUtil.back = option;
                        returnNode();
                        break;
                    case "..":
                        OrderUtil.back = option;
                        returnParent();
                        break;
                    default:
                        OrderUtil.back = option;
                        goIntoDir(option);
                        break;
                }
            case "mkdir":
                makeDir(option);
                break;
            case "rmdir":
                rmdir(option);
                break;
            case "shutdown":
                shutdown(option);
                break;
            default:

        }
    }

    private static void goIntoDir(String option) {
        if (option.startsWith("/")) {
            String temp = OrderUtil.path;
            OrderUtil.path = option;
            if (OrderUtil.file.exists()) {
                System.out.print(OrderUtil.location);
            } else {
                OrderUtil.path = temp;
            }
        } else {
            String temp = OrderUtil.path;
            OrderUtil.path += option;
            if (OrderUtil.file.exists()) {
                System.out.print(OrderUtil.location);
            } else {
                System.out.print("System not find the directory:'" + option + "'");
                OrderUtil.path = temp;
            }
        }
        CommandUtil.printLocation();
    }

    private static void rmdir(String option) {
        System.out.println("do you sure to delete the file?");
        Scanner scanner = new Scanner(System.in);
        if ("y".equals(scanner.next())) {
            String temp = OrderUtil.path;
            OrderUtil.path += option;
            if (!OrderUtil.file.delete()) {
                System.out.println("no empty or protected");
            }
            OrderUtil.path = temp;
        }
        CommandUtil.printLocation();
    }

    private static void shutdown(String option) {
        if (option.startsWith("-")) {
            switch (option.substring(1)) {
                case "p":
                    shutdownPower();
            }
        } else if ("now".equals(option)) {
            System.exit(0);
        }
    }

    private static void shutdownPower() {
        System.out.println("System will exit in one minute and the daemon will be closed");
    }

    private static void makeDir(String option) {
        if (option.startsWith("/")) {
            String temp = OrderUtil.path;
            OrderUtil.path = option;
            OrderUtil.file.mkdirs();
            OrderUtil.path = temp;
            CommandUtil.printLocation();
        } else {
            String temp = OrderUtil.path;
            OrderUtil.path += option;
            OrderUtil.file.mkdir();
            OrderUtil.path = temp;
            CommandUtil.printLocation();
        }

    }

    private static void returnNode() {
        OrderUtil.path = OrderUtil.back;
        CommandUtil.printLocation();
    }

    private static void returnParent() {
        int index = OrderUtil.path.lastIndexOf("/");
        OrderUtil.path = OrderUtil.path.substring(0, index);
        CommandUtil.printLocation();
    }

    private static void returnRootHome() {
        OrderUtil.path = "/home";
        CommandUtil.printLocation();
    }

    private static void returnRoot() {
        OrderUtil.path = "/";
        CommandUtil.printLocation();
    }
}
