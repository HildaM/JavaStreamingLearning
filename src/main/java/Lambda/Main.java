package Lambda;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;

public class Main {
    public static void main(String[] args) {
        new Test().test03();
    }
}

class Test {
    public void ThreadTest() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread without Lambda");
            }
        }).start();

        new Thread(() -> {
            System.out.println("Thread Lambda");
        }).start();
    }

    public static int calculateNum(IntBinaryOperator operator) {
        int a = 10, b = 20;
        return operator.applyAsInt(a, b);
    }
    public void test01() {
        int res01 = calculateNum(new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {
                return left + right;
            }
        });

        int res02 = calculateNum((a, b) -> a + b);

        System.out.println(res01 == res02);
    }


    public static void printNum(IntPredicate predicate) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i : arr) {
            if (predicate.test(i)) System.out.println(i);
        }
    }
    public void test02() {
        printNum(new IntPredicate() {
            @Override
            public boolean test(int value) {
                return value % 2 == 0;
            }
        });

        printNum((x) -> x % 2 == 0);
    }


    public static <R> R typeConver(Function<String, R> function) {
        String str = "12345";
        R res = function.apply(str);
        return res;
    }
    public void test03() {
        Integer num1 = typeConver(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.valueOf(s);
            }
        });

        Integer num2 = typeConver((s) -> Integer.valueOf(s));
        System.out.println(Objects.equals(num1, num2));
    }
}
