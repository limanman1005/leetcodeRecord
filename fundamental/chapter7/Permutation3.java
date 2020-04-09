package chapter7;

/**
 * ClassName: Permutation3
 * Description: 求全排列中的第几个序列
 * date: 2020/4/8 17:25
 * 这个题的递归，是如何回溯的也要重新看下了
 * @author liyh
 */
public class Permutation3 {
    private static int count = 0;
    private final static int k = 3;
    public static void permutation(String prefix, char[] arr){
        if(prefix.length() == arr.length){
            count++;
            if(count == k){
                System.out.println("------------:" + prefix);
                System.exit(0);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            //这个判断是为了避免字符数组中有重复的元素
            if(countChar(prefix.toCharArray(), ch) < countChar(arr, ch)){
                permutation(prefix + ch, arr);
            }
        }
    }

    private static int countChar(char[] arr, char ch) {
        int cnt = 0;
        for (char c : arr) {
            if( c == ch){
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        permutation("", "123".toCharArray());
    }
}
