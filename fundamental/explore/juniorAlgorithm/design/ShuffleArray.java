package explore.juniorAlgorithm.design;

import java.util.Random;

/**
 * ClassName: ShuffleArray
 * Description: 打乱数组的算法。适用交换代替重置数组。解答里面还有其他人的解法，也值得一看。
 * date: 2020/6/6 12:44
 *
 * @author liyh
 */
public class ShuffleArray {
    public static void main(String[] args) {
        Random random = new Random();
        int i = random.nextInt(9);
        System.out.println(i);
    }
}

class Solution384 {
    private int[] array;
    private int[] original;
    Random rand = new Random();

    private int randRange(int min, int max){
        return rand.nextInt(max - min) + min;
    }

    public Solution384(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    private void swap(int i, int j){
        int temp =  array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        array = original;
        original =  original.clone();
        return original;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for(int i = 0; i < array.length; ++i){
            swap(i, randRange(i, array.length));
        }
        return array;
    }
}
