package niucode.shein;

/**
 * ClassName: YunZhiTest
 * Description:
 *
 * @author liyh
 */
public class YunZhiTest {

    public static void main(String[] args) {
        YunZhiTest yunZhiTest = new YunZhiTest();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] nums3 = {1, 2, 2, 4, 5, 6, 7, 8, 8};
        int target1 = 2;
        int target2 = 10;
        int index1 = yunZhiTest.binarySearch(nums, target1);
        int index2 = yunZhiTest.binarySearch(nums, target2);
        int index3 = yunZhiTest.binarySearch(nums3, target1);
        int index4 = yunZhiTest.binarySearch(nums3, target2);
        System.out.println("index1 = " + index1);
        System.out.println("index2 = " + index2);
        System.out.println("index3 = " + index3);
        System.out.println("index4 = " + index4);
    }


    public int binarySearch(int[] nums, int target){

        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left + right) >>> 1;
            if(nums[mid] < target){
                left = mid + 1;
            }
            else if(nums[mid] > target){
                right = mid - 1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }

}
