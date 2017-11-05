import java.io.*;
import java.util.Iterator;

public class CommandUtil {
    public static void Cd() {
        OrderUtil.path = "/" + OrderUtil.userName;
        System.out.print(OrderUtil.location);
    }

    public static void listFileAcross() {
        if (OrderUtil.file.isDirectory()) {
            File[] file = OrderUtil.file.listFiles();
            int length = 0;
            for (File file1 : file) {
                if (file1.getName().length() < 70) {
                    length += file1.getName().length();
                    if (length > 70) {
                        System.out.println();
                    } else {
                        System.out.print(file1);
                    }
                } else {
                    System.out.println(file1);
                }
            }
        } else {
            System.out.print(OrderUtil.file);
        }
    }

    public static void mkdir() {
        System.out.println("use command mkdir like: mkdir [option] [argument]");
        System.out.println("eg: mkdir -p /test/test.txt");
    }

    public static void rmdir() {
        System.out.println("use command rmdir like: rmdir [option] [argument]");
        System.out.println("eg: mkdir /s /test");
    }


    public static void shutdown() {
        System.out.println("the system will exit in one minute,use shutdown -c to revert the option");
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    public static void execute(String command) {
        if (null == command) {
            //path保留当前路径
            System.out.print(OrderUtil.location);
        } else {
            switch (command) {
                case "cd":
                    Cd();
                case "ls":
                    listFileAcross();
                case "ll":
                    listFileVertical();
                case "mkdir":
                    mkdir();
                case "rmdir":
                    rmdir();
                case "pwd":
                    ShowPath();
                case "cat":
                    cat();
                case "vim":
                    vi();
                case "vi":
                    vi();
                case "ifconfig":
                    ip();
                case "shutdown":
                    shutdown();
                case "help":
                    help();
                default:
                    notRealize();
            }
        }
    }

    private static void ip() {
        System.out.print(OrderUtil.ip);
    }

    //TODO
    /*
    to check
     */
    private static void cat() {
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
            System.out.print(OrderUtil.location);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void vi() {

    }

    private static void ShowPath() {
        System.out.println(OrderUtil.path);
    }

    private static void listFileVertical() {
        if (OrderUtil.file.isDirectory()) {
            File[] file = OrderUtil.file.listFiles();
            for (File file1 : file) {
                System.out.print(file1);
            }
        } else {
            System.out.print(OrderUtil.file);
        }
    }

    private static void help() {
        System.out.println("cd: go into a directory ");
        System.out.println("ls: list fileName across");
        System.out.println("ll: list fileName vertical");
        System.out.println("mkdir: make a file");
        System.out.println("rmdir: remove a file");
        System.out.println("shutdown: power off the computer");
        System.out.println("ifconfig:ip address");
    }

    private static void notRealize() {
        System.out.println("the command:‘" + OrderUtil.command + "’is not support now,please wait and see,thank you");
    }
}
