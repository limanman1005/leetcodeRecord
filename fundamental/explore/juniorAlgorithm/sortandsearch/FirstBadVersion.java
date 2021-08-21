package explore.juniorAlgorithm.sortandsearch;

/**
 * ClassName: FirstBadVersion
 * Description: 调用另一个函数得到结果，很明显的二分查找的使用
 * date: 2020/6/19 17:42
 * @author liyh
 */
public class FirstBadVersion {
}

class Solution278 {
    /**
     * 使用二分查找
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while(left < right){
            int mid = (left + right) >>> 1;
            boolean result = isBadVersion(mid);
            if(!result){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }
    private boolean isBadVersion(int mid) {
        return true;
    }
}

