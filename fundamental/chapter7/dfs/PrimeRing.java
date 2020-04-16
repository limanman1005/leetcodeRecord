package chapter7.dfs;

import com.sun.xml.internal.bind.Util;

import java.util.Scanner;

/**
 * ClassName: PrimeRing
 * Description: 输入正整数n，对1 - n进行排列，使得相邻两个数之和均为素数
 * 输出时从整数1来时，逆时针排列。同一个环应恰好输出一次
 * date: 2020/4/9 11:28
 * 测试用例：
 * 如输入：6
 * 输出：
 * 1 4 3 2 5 6
 * 1 6 5 2 3 4
 * @author liyh
 */
public class PrimeRing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        arr[0] = 1;
        dfs(n, arr, 1);
    }

    /**
     * 核心dfs。
     * @param n 给的大小
     * @param arr 数组
     * @param cur 当前试探的位置
     */
    private static void dfs(int n, int[] arr, int cur) {
        //如果到了cur最后一位，并且和第一位相加还是素数。则满足条件打印输出
        if(cur == n && isPrime(arr[0] + arr[n - 1])){
            printArr(arr);
            return;
        }
        //从2开始试。
        for(int i = 2; i <= n; ++i){
            //检查下能不能放到当前的位置
            //检查就相当于提前剪枝了
            if(check(arr, i, cur)){
                arr[cur] = i;
                //放进去之后找下一个位置
                dfs(n, arr, cur + 1);
                //回溯
                arr[cur] = 0;
            }
        }
    }

    private static void printArr(int[] r) {
        for (int i = 0; i < r.length; i++) {
            System.out.print(r[i] + (i == r.length - 1? "" : " "));
        }
        System.out.println();
    }

    private static boolean isPrime(int k) {
        for(int i = 2; i * i <= k; ++i){
            if(k%i == 0){
                return false;
            }
        }
        return true;
    }

    /**
     * 这个判断能不能放进去
     * @param r 目标数组
     * @param i 想要放进去的数
     * @param cur 当前放的位置
     * @return 结果
     */
    private static boolean check(int[] r, int i, int cur) {
        //对数组里面已经放进去的数进行判断
        for(int e : r){
            //如果已经放进去过或者和前一个数相加不是素数，则不能放
            if(e == i || !isPrime(r[cur - 1] + i)){
                return false;
            }
        }
        //否则可以放。
        return true;
    }
}
