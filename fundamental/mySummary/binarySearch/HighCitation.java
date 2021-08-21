package mySummary.binarySearch;

/**
 * ClassName: HighCitation
 * Description: 这个题本来不是二分查找，主要还有一些启发性质，我就放这了。
 * date: 2020/4/23 21:59
 *
 * @author liyh
 */
public class HighCitation {
}


class Solution274 {

    /**
     * 此为不排序的做法。 可使用排序后的另一个方法
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        int n = citations.length;
        //使用一个辅助数组，下标是引用的次数，内容是有多少文章。
        //只用开到n。大于n的可以合到n处。
        int[] papers = new int[n+1];
        //按照意义填充数组
        //超过n的引用次数无意义，归并到n就好
        for(int c : citations){
            papers[Math.min(n, c)]++;
        }
        int count = 0;
        for(int i = n; i >= 0; i--){
            count += papers[i];
            //这个条件就是代表，找到第一个引用次数大于等于i的文章数大于等于i篇文章。
            if(count >= i){
                return i;
            }
        }
        return 0;
    }
}
