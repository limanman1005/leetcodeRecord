package offer.no10SearchAndSort;

/**
 * ClassName: Offer069
 * Description:
 * date: 4/5/2022 下午5:31
 *
 * @author liyh
 */
public class Offer069 {
}
class SolutionOffer069And852 {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 1;
        int right = arr.length - 2;
        while(left <= right){
            int mid = (left + right) >>> 1;
            if(arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]){
                return mid;
            }
            if(arr[mid] > arr[mid - 1]){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return -1;
    }
}
