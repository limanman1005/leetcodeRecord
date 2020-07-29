package Recursive;

/**
 * ClassName: Recursive.RecursiveFundamental0320
 * Description:
 * date: 2020/3/20 0:17
 *
 * @author liyh
 */
public class RecursiveFundamental0320 {
    private static int ans;
    private static StringBuilder sb = new StringBuilder();


    /**
     * 无返回值的数组求和第一种方式
     * @param nums
     * @param i
     */
    public static void arrSum1(int[] nums, int i){
        if(i >= nums.length){
            return;
        }
        ans += nums[i];
        arrSum1(nums, i+1);
    }

    /**
     * 这个是有返回值的递归求数组的和
     * @param nums
     * @param i
     * @return
     */
    public static int arrSum2(int[] nums, int i){
        if(i == nums.length -1 ){
            return nums[i];
        }
        return nums[i] + arrSum2(nums, i+1);
    }

    public static String reverseString(String str){
        if(str.length() == 1){
            return str;
        }
        return reverseString(str.substring(1)) + str.charAt(0);
    }


    //这个更像是循环思路写的东西
    public static void reverseString2(String str){
        if(str.length() == 0){
            return;
        }
        sb.append(str.charAt(str.length()-1));
        reverseString2(str.substring(0, str.length()-1));
    }


    /**
     * 这个sb在这方法里毫无作为啊
     * @param str
     * @return
     */
    public static String reverseString3(String str){
        if(str.length() == 1){
            sb.append(str);
            return str;
        }
        String temp = str.charAt(str.length()-1) + reverseString3(str.substring(0, str.length()-1));
        sb.append(temp);
        return temp;
    }

    /**
     * 这个是有返回值的思路。碰到只有一个字符的时候（字符串为空时特殊用例）就返回。
     * 然后把这个字符串的头去掉调用自己，然后在后面拼接上头。实现了反转。
     * @param str
     * @return
     */
    public static String reverseString4(String str){
        if(str == null || str.length() == 0){
            return str;
        }
        return reverseString(str.substring(1)) + str.charAt(0);
    }

    /**
     * 这个是无返回值的思路。每次都append最后一个字符，然后把这个字符串最后一个字符去掉递归就好了。
     * @param str
     */
    public static void reverseString5(String str){
        if(str.length() == 0){
            return;
        }
        sb.append(str.substring(str.length()-1));
        reverseString5(str.substring(0, str.length()-1));
    }

    /**
     * 这个是无返回值的另一种思路。递归把问题分解之后，使用sb的append的加上第一个元素。边界就是传过去的长度改为零了。
     * @param str
     */
    public static void reverseString6(String str){
        if(str.length() == 0){
            return;
        }
        reverseString6(str.substring(1));
        sb.append(str.charAt(0));
    }


    /**
     * 这个斐波那契数列没什么好说的。
     * @param n
     * @return
     */
    public static Integer fib(int n){
        if(n == 2 || n == 1){
            return 1;
        }
        ans = fib(n-1) + fib(n-2);
        return ans;
    }

    /**
     * 辗转相除法的递归形式。这个我喜欢
     * @param m
     * @param n
     * @return
     */
    public static Integer gcd(int m, int n){
        if(n == 0){
            return m;
        }
        int ans = gcd(n, m%n);
        return ans;
    }

    /**
     * 插入排序从后后前递归
     * @param arr
     * @param n
     */
    public static void insertSort(int[] arr, int n){
        if(n == 0){
            return;
        }
        //这一步是把前面n - 1个数拍好。
        insertSort(arr, n-1);
        //后面这些步骤是如何把第n个数插入到前面n - 1个数前面
        int value = arr[n];
        int index = n - 1;
        while(index > -1 && value < arr[index]){
            arr[index+1] = arr[index];
            index--;
        }
        arr[index+1] = value;
    }

    /**
     * 这个插入排序的从前往后递归。的确没有从后往前自然一点
     * @param arr
     * @param n
     */
    public static void insertSort2(int[] arr, int n){
        if(n > arr.length -1 ){
            return;
        }
        //首先把第n个数插进前面
        int value = arr[n];
        int index = 0;
        while(index < n && value > arr[index]){
            index++;
        }
        int temp = n;
        while(temp > index){
            arr[temp] = arr[temp-1];
            temp--;
        }
        arr[index] = value;
        //然后递归的插进去第n + 1个数
        insertSort2(arr, n+1);
    }

    /**
     * 反转字符串和7和8倒是挺一直的都是无返回值的时候好用的多。
     * @param str
     */
    public static void reverseString7(String str){
        if(str.length() == 0){
            return;
        }
        reverseString7(str.substring(1));
        sb.append(str.charAt(0));
    }


    /**
     * 这个和7一样
     * @param str
     */
    public static void reverseString8(String str){
        if(str.length() == 0){
            return;
        }
        sb.append(str.charAt(str.length()-1));
        reverseString8(str.substring(0, str.length()-1));
    }

    public static String reverseString9(String str){
        if(str.length() == 1){
            return str;
        }
        String ans = reverseString9(str.substring(1)) + str.charAt(0);
        return ans;
    }
    public static String reverseString10(String str){
        if(str.length() == 1){
            return str;
        }
        String ans = str.charAt(str.length()-1) + reverseString10(str.substring(0, str.length()-1));
        return ans;
    }

    /**
     * 数组求和，无返回值，从前往后推
     * @param arr
     * @param k
     */
    public static void arrSum3(int[] arr, int k){
        if(k == arr.length){
            return;
        }
        ans += arr[k];
        arrSum3(arr, k+1);
    }

    /**
     * 数组求和，无返回值，从后往前推，做了一个全局变量
     * @param arr
     * @param k
     */
    public static void arrSum4(int[] arr, int k){
        if(k < 0){
            return;
        }
        ans += arr[k];
        arrSum4(arr, k-1);
    }

    /**
     * 数组求和，有返回值，从前往后推
     * @param arr
     * @param k
     * @return 下标为0到k的数组的和
     */
    public static int arrSum5(int[] arr, int k){
        if(k == arr.length - 1){
            return arr[k];
        }
        int temp = arr[k] + arrSum5(arr, k+1);
        return temp;
    }

    /**
     * 数组求和，无返回值，从后往前推
     * @param arr
     * @param k
     * @return 下标为k到arr.length - 1的和
     */
    public static int arrSum6(int[] arr, int k){
        if(k == 0){
            return arr[0];
        }
        return arr[k] + arrSum6(arr, k-1);
    }

    public static void main(String[] args) {
//        int[] randomArr = Util.getRandomArr(10, -100, 100);
//        insertSort(randomArr, randomArr.length-1);
//        for (int i = 0; i < randomArr.length; i++) {
//            System.out.println(randomArr[i]);
//        }
//        reverseString7("123456");
//        System.out.println(sb.toString());
//        System.out.println(reverseString10("123"));
//        int[] arr = {1, 2, 3, 4, 5};
//        System.out.println(arrSum6(arr, arr.length-1));
    }

}
