package beautyOfAlgorithm.chapter7;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * ClassName: Permutation2
 * Description: 从一个字符数组里面，不断的选取当前的字符作为当前位置的字符。然后选取下一个字符
 * 最后回溯。
 * date: 2020/4/8 16:32
 *
 * @author liyh
 */
public class Permutation2 {
    private static ArrayList<String> res = new ArrayList<>();

    public static ArrayList<String> getPermutation(String str){
        char[] chars = str.toCharArray();
        //对进行选取的元素进行排序以满足字典序。
        Arrays.sort(chars);
        //全排列核心代码
        getPermutationCore(chars, 0);
        return res;
    }

    /**
     * 递归的思想就是当第k个位置上，选择一遍字符数组k位置以后的元素。然后进行下一个位置的递归。
     * 直到k达到了长度的要求，则生成了一个答案。最后记得回溯。
     * @param chars 字符数组
     * @param k k有两个意思，一个就是
     */
    private static void getPermutationCore(char[] chars, int k) {
        //k代表当前选取到第几个元素了
        //如果长度够大了，说明结果出来了
        if(k == chars.length){
            res.add(new String(chars));
        }
        //这个代表从k开始还有后面的元素可以选择
        for(int i = k; i < chars.length; ++i){
            //首先就要把k之后的元素都交换到k这个位置上来
            swap(chars, k, i);
            //递归的把下一个位置上的所有可能的元素交换到k+1这个位置上来。
            getPermutationCore(chars, k + 1);
            //回溯
            swap(chars, k, i);
        }
    }

    private static void swap(char[] chars, int k, int i) {
        char tmp = chars[k];
        chars[k] = chars[i];
        chars[i] = tmp;
    }

    public static void main(String[] args) {
        ArrayList<String> strings = getPermutation("123");
        System.out.println(strings.toString());
    }
}
