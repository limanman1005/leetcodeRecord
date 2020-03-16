/**
 * ClassName: Util
 * Description:
 * date: 2020/3/16 0:39
 *
 * @author liyh
 */
public class Util {
    public static void swap(int[] nums, int i, int j){
        int len = nums.length;
        if(i >= len || j >= len){
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 获取指定范围指定个数的随机数组成的数组
     *
     * @param length
     * @param min
     * @param max
     * @return
     */
    public static int[] getRandomArr(int length, int min, int max) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (int) (Math.random() * (max + 1 - min) + min);
        }
        return arr;
    }
}
