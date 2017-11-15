import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

public class OptionUtil {
    public static void execute(String command, String option) {
        switch (command) {
            case "cd":
                switch (option) {
                    case "/":
                        CommandUtil.backPath();
                        returnRoot();
                        break;
                    case "~":
                        CommandUtil.backPath();
                        returnRootHome();
                        break;
                    case "-":
                        CommandUtil.backPath();
                        returnNode();
                        break;
                    case "..":
                        CommandUtil.backPath();
                        returnParent();
                        break;
                    default:
                        CommandUtil.backPath();
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
            case "cat":
                cat(option);
                break;
            case "vi":
                vi(option);
            default:
        }
    }

    private static void vi(String option) {
        updatePath(option);
        //TODO

    }

    static void updatePath(String option) {
        if (option.startsWith("/")) {
            OrderUtil.path = option;
        } else {
            OrderUtil.path += option;
        }
    }

    private static void cat(String option) {
        updatePath(option);
        OrderUtil.updateFile();
        try {
            Reader reader = new FileReader(OrderUtil.file);
            int i = 140;
            int off = 0;
            char[] a = new char[i];
            while (reader.read() != -1) {
                reader.read(a, off, i);
                off += i;
                for (char c : a) {
                    System.out.print(c);
                }
                if (OrderUtil.file.length() - off > i) {
                    System.out.println();
                }
            }
            CommandUtil.printLocation();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void goIntoDir(String option) {
        updatePath(option);
        if (OrderUtil.file.exists()) {
            System.out.print(OrderUtil.location);
        } else {
            System.out.println("System not find the directory:'" + option + "'");
        }
        CommandUtil.printLocation();
    }

    private static void rmdir(String option) {
        System.out.println("do you sure to delete the file?");
        Scanner scanner = new Scanner(System.in);
        if ("y".equals(scanner.next())) {
            //TODO

            if (!OrderUtil.file.delete()) {
                System.out.println("not empty or protected");
            }
        }
        CommandUtil.printLocation();
    }

    private static void shutdown(String option) {
        if (option.startsWith("--")) {
            switch (option.substring(1)) {
                case "p":
                    shutdownPower();
                    break;
                default:
            }
        } else if ("now".equals(option)) {
            System.exit(0);
        }
    }

    private static void shutdownPower() {
        System.out.println("System will exit in one minute and the daemon will be closed");
    }

    private static void makeDir(String option) {
        CommandUtil.backPath();
        OrderUtil.file.mkdir();
        CommandUtil.printLocation();
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
        OrderUtil.path = "/" + OrderUtil.userName;
        CommandUtil.printLocation();
    }

    private static void returnRoot() {
        OrderUtil.path = "/";
        CommandUtil.printLocation();
    }
}
