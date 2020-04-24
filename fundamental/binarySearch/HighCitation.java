package binarySearch;

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
        for(int c : citations){
            papers[Math.min(n, c)]++;
        }
        //从可能的最高n开始，拿出数组里面的值（即引用为n的文章数）和第n篇文章开始对比
        int k = n;
        //paper[k]里面存的是大于等于下标的文章数，所以这里加上这个数即（s += papers[k]）
        //k表示有几篇文章。
        for(int s = papers[n]; k > s; s += papers[k]){
            k--;
        }
        return k;
    }
}
