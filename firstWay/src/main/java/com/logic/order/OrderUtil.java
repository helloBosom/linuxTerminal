package com.logic.order;

import java.io.File;


public class OrderUtil {
    public static String path = "/";
    public static String left = "[";
    public static String right = "]#";
    public static File file;
    public static String userName;
    public static String ip;
    public static String location;
    public static String order;
    public static String command;
    public static String argument;
    public static String option;
    public static String temp;
    public static String back;
    public static int index;
    public static boolean flag;

    public static void updateUserName() {
        userName = System.getProperties().getProperty("user.name");
    }

    public static void updateIp() {
//        try {
//            ip = InetAddress.getLocalHost().getHostAddress();
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }
        ip = getLinuxIP.getLinuxLocalIp() + " ";
    }

    public static void updateFile() {
        file = new File(path);
    }

    public static void dealOrder() {
        if (order != null) {
            Terminal terminal = new Terminal();
            command = useString();
            terminal.setCommand(command);
            if (flag) {
                option = useString();
                terminal.setOption(option);
                if (flag) {
                    argument = useString();
                    terminal.setArgument(argument);
                }
            }
            OrderExecuteImpl.execute(terminal);
        } else {
            System.out.printf(location);
        }
    }

    public static void UpdateLocation() {
        OrderUtil.location
                = OrderUtil.left + OrderUtil.userName + "@" + OrderUtil.ip + OrderUtil.path + OrderUtil.right;
    }

    private static String useString() {
        order = order.trim();
        isContainSpace();
        if (flag) {
            index = order.indexOf(" ");
            temp = order.substring(0, index - 1);
            order = order.substring(index, order.length() - 1);
        } else {
            temp = order;
        }
        return temp;
    }

    private static void isContainSpace() {
        if (order.contains(" ")) {
            flag = true;
        } else {
            flag = false;
        }

    }

}
