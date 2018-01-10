import com.logic.order.CommandUtil;
import com.logic.order.OrderUtil;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        System.out.println(System.getProperties().getProperty("os.name"));
        System.out.println(System.getProperties().getProperty("os.arch"));
        System.out.println(System.getProperties().getProperty("os.version"));
        OrderUtil.updateUserName();
        OrderUtil.updateIp();
        //登录需判断。本例为实验测试，初始化默认以root用户登录，初始路径为/，初步运行环境为IDE，暂不考虑多进程、多线程
        //OrderUtil.updatePath()用来以用户区分目录,暂略过。
        CommandUtil.printLocation();
        Scanner scan = new Scanner(System.in);
        while (true) {
            OrderUtil.order = scan.next();
            OrderUtil.dealOrder();
        }
    }

}
