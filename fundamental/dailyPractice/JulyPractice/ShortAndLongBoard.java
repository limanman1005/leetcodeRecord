package dailyPractice.JulyPractice;

/**
 * ClassName: ShortAndLongBoard
 * Description: 给长短不同的几个木板，并且给定一个数量，求使用这些木板可以组成的长度。并按大小排列
 * date: 2020/7/8 9:47
 *
 * @author liyh
 */
public class ShortAndLongBoard {
    public static void main(String[] args) {
        ClassLoader classLoader = ShortAndLongBoard.class.getClassLoader();
        System.out.println(classLoader);
        ClassLoader parent = classLoader.getParent();
        System.out.println(parent);
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);
    }
}
class Solution16_11 {
    /**
     * 直接使用数学方法，一次循环搞定
     * @param shorter
     * @param longer
     * @param k
     * @return
     */
    public int[] divingBoard(int shorter, int longer, int k) {
        if(k == 0){
            return new int[0];
        }
        //注意这个特殊情况
        if(shorter == longer){
            return new int[]{shorter * k};
        }
        //一共有k+1个情况
        int[] ans = new int[k + 1];
        //使用循环遍历
        for(int i = 0; i <= k; ++i){
            ans[i] = i * longer + (k - i) * shorter;
        }
        return ans;
    }
}
