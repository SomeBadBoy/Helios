package leetcode._16;

import org.junit.Test;

/**
 * @author wenqi.wei created on 2017/7/20
 * @version 1.0
 */
public class _3SumClosestTest {
    @Test
    public void threeSumClosest() throws Exception {
        _3SumClosest solution = new _3SumClosest();
        System.out.println(solution.threeSumClosest(new int[]{1, 1, -1}, 2));
    }

    public static void main(String[] args) {
        final HashCode hashCode = new HashCode();
        new Thread(() -> {
            synchronized (hashCode) {
                hashCode.func();
            }
        }).start();
        new Thread(hashCode::syncFunc).start();
        new Thread(HashCode::staticFunc).start();
    }

    static class HashCode {
        public static synchronized void staticFunc() {
            for (int i = 0; i < 100; i++) {
                System.out.println("static:" + i);
            }
        }

        public synchronized void syncFunc() {
            for (int i = 0; i < 100; i++) {
                System.out.println("sync:" + i);
            }
        }

        public void func() {
            for (int i = 0; i < 100; i++) {
                System.out.println("this:" + i);
            }
        }
    }
}