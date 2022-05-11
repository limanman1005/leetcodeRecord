package offer;

/**
 * ClassName: Offer075
 * Description:
 * date: 6/5/2022 下午4:50
 *
 * @author liyh
 */
public class Offer075 {
}
class SolutionOffer075{
    /**
     * 计数排序的的数字下标是数值，内容是频率。
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count1 = new int[1001];
        for(int num: arr1){
            count1[num]++;
        }
        int[] ans = new int[arr1.length];
        int idx = 0;
        for(int i = 0; i < arr2.length; ++i){
            while(count1[arr2[i]] > 0){
                ans[idx++] = arr2[i];
                count1[arr2[i]]--;
            }
        }
        for(int i = 0; i < 1001; ++i){
            while(count1[i] > 0){
                ans[idx++] = i;
                count1[i]--;
            }
        }
        return ans;
    }
}
