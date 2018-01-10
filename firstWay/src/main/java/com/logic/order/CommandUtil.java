package com.logic.order;

import java.io.*;

public class CommandUtil {
    public static void Cd() {
        backPath();
        OrderUtil.path = "~";
        printLocation();
    }

    static void backPath() {
        OrderUtil.back = OrderUtil.path;
    }

    static void printLocation() {
        OrderUtil.UpdateLocation();
        System.out.print(OrderUtil.location);
    }

    public static void listFileAcross() {
        OrderUtil.updateFile();
        if (OrderUtil.file.isDirectory()) {
            File[] file = OrderUtil.file.listFiles();
            int length = 0;
            for (File file1 : file) {
                if (file1.getName().length() < 70) {
                    length += file1.getName().length();
                    if (length > 70) {
                        System.out.print("\r\n");
                        length = 0;
                        continue;
                    } else {
                        System.out.print(file1 + " ");
                    }
                } else {
                    System.out.print(file1);
                }
            }
        } else {
            System.out.print(OrderUtil.file);
        }
        System.out.print("\r\n");
        CommandUtil.printLocation();
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
            printLocation();
        } else {
            switch (command) {
                case "cd":
                    Cd();
                    break;
                case "ls":
                    listFileAcross();
                    break;
                case "ll":
                    listFileVertical();
                    break;
                case "mkdir":
                    mkdir();
                    break;
                case "rmdir":
                    rmdir();
                    break;
                case "pwd":
                    ShowPath();
                    break;
                case "cat":
                    cat();
                    break;
                case "vim":
                    vi();
                    break;
                case "vi":
                    vi();
                    break;
                case "ifconfig":
                    ip();
                    break;
                case "shutdown":
                    shutdown();
                    break;
                case "help":
                    help();
                    break;
                default:
                    notRealize();
                    break;
            }
        }
    }

    private static void ip() {
        System.out.println(OrderUtil.ip);
        printLocation();
    }

    //TODO
    /*
    to check
     */
    private static void cat() {
        System.out.println("use cat like 'cat [option] [argument]'");
    }

    private static void vi() {
        System.out.println("use vi like 'vi [option] [argument]'");
    }

    private static void ShowPath() {
        System.out.println(OrderUtil.path);
        printLocation();
    }

    private static void listFileVertical() {
        OrderUtil.updateFile();
        if (OrderUtil.file.isDirectory()) {
            File[] file = OrderUtil.file.listFiles();
            for (File file1 : file) {
                System.out.println(file1);
            }
        } else {
            System.out.println(OrderUtil.file);
        }
        printLocation();
    }

    private static void help() {
        System.out.println("cd: go into a directory ");
        System.out.println("ls: list fileName across");
        System.out.println("ll: list fileName vertical");
        System.out.println("mkdir: make a file");
        System.out.println("rmdir: remove a file");
        System.out.println("shutdown: power off the computer");
        System.out.println("ifconfig:ip address");
        System.out.println("...");
        printLocation();
    }

    private static void notRealize() {
        System.out.println("the command: '" + OrderUtil.command + "' is not support now,please wait and see,thank you");
    }
}
