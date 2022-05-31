package offer.amzon.oa;

/**
 * ClassName: FindLeftCloestNum
 * Description:
 * date: 28/5/2022 上午9:57
 *
 * @author liyh
 */
public class FindLeftCloestNum {
    /**
     * 和寻找插入位置是一样的
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 6, 7, 8, 10};
        int left = 0;
        int right = arr.length - 1;
        int target =  1;
        while(left <= right){
            int mid = (left + right) >>> 1;
            if(arr[mid] < target){
                left = mid + 1;
            }
            else if(arr[mid] > target){
                right = mid - 1;
            }
            else {
                System.out.println("find " + arr[mid]);
            }
        }
        if(right < 0){
            System.out.println("Cannot fly back");
            System.out.println("arr[0] = " + arr[0]);
        }
        else{
            System.out.println("arr[right] = " + arr[right]);
        }
    }
}
