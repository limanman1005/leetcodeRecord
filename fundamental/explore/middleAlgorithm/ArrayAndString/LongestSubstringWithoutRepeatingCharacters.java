package explore.middleAlgorithm.ArrayAndString;

import java.util.Arrays;

/**
 * ClassName: LongestSubstringWithoutRepeatingCharacters
 * Description: 给一个字符串，找到子串中不含重复字符的子串的最大长度
 * 此题是lc的第三道题。五月每日一练中做过。
 * 典型的滑动窗口题目，相同的题还有3， 30， 76， 159， 209， 239， 567， 632，727
 * date: 2020/6/27 17:59
 *
 * @author liyh
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int[] copy = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < copy.length; i++) {
            System.out.println("copy[i] = " + copy[i]);
        }
    }
}
class Solution03{

}
