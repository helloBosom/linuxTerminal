import com.logic.order.HomeThread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Z_shell 模拟系统 主页
 *
 */
public class Home {
    public static void main(String[] args) {
        System.out.println("welcome to z_shell");
        System.out.println("input --help or -h get helper");
        Thread homeThread = new HomeThread();
        Executor executor = Executors.newCachedThreadPool();
        executor.execute(homeThread);
    }
}
