package binarySearch;

/**
 * ClassName: HighCitations2
 * Description: H指数。如果一个H指数按照大小排好序之后如何快速的找到它
 * date: 2020/4/23 21:45
 *
 * @author liyh
 */
public class HighCitations2 {

    public static void main(String[] args) {
        int[] arr = {0};
        System.out.println(new Solution275().hIndex2(arr));
        System.out.println(new Solution275().hIndex(arr));
    }
}

class Solution275 {

    /**
     *
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        int len = citations.length;
        int left = 0;
        int right = len - 1;
        //使用小于号，使得left和right重和即可。
        while(left < right){
            int mid = (left + right + 1) >>> 1;
            //这个判断条件说明len - mid说明有len - mid数量的论文大于处于mid位置的论文引用数
            //表明这个论文数应该在右边（即这个论文的H指数比较的低）。至少减小1。
            if(citations[mid] < len - mid){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return len - left;
    }

    /**
     * 从后往前遍历引用数组的解法
     * @param citations
     * @return
     */
    public int hIndex2(int[] citations){
        //第几个论文
        int n = 1;
        //从大到小遍历引用数组。如果论文数逐渐增加，引用数逐渐减少。
        //找到最大的论文数，即H指数
        for(int i = citations.length - 1; i >= 0; i--){
            //如果论文数大于了引用数就跳出循环
            if (n > citations[i]){
                break;
            }
            n++;
        }
        //这的n-1也暗合了引用为零的情况。
        return n - 1;
    }

    /**
     * 从前向后遍历引用数组的解法
     * @param citations
     * @return
     */
    public int hIndex3(int[] citations){
        int n = citations.length;
        //数组里面是引用的次数，已经从小到大排列了。
        //从最小的引用数开始，引用数逐渐增加，论文数逐渐减小。
        //找到第一个应用大于等于论文数的论文数就是H指数
        for(int i = 0; i < n; ++i){
            //这里的意思是当前引用的次数比论文数要大了
            //然后返回论文数就好了
            if(citations[i] >= n - i){
                return n - i;
            }
        }
        return 0;
    }
}
