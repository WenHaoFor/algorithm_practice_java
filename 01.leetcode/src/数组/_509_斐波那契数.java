package 数组;
/*
* https://leetcode-cn.com/problems/fibonacci-number/
* 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。
* 该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
* F(0) = 0，F(1) = 1
* F(n) = F(n - 1) + F(n - 2)，其中 n > 1
* 给你 n ，请计算 F(n) 。
* 0,1,1,2,3,5,8,13
* */
public class _509_斐波那契数 {
    public static void main(String[] args) {
        System.out.print(fib1(7));
        System.out.print("\n");
        System.out.print(fib2(7));
    }

    // 递归解法
    private static int fib1(int n) {
        if (n <= 1) return n;
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = fib1(i - 1) + fib1(i - 2);
        }
        return sum;
    }

    // 非递归解法
    private static int fib2(int n) {
        if (n <= 1) return n;
        int first = 0;
        int second = 1;
//        int sum = second;
        for (int i = 2; i <= n; i++) {
            second = first + second;
            first = second - first;
        }
        return second;
    }
}
