package niucode.shopee.three;

import java.util.Arrays;

/**
 * ClassName: Main
 * Description:
 * date: 2021/10/25 15:25
 *
 * @author liyh
 */
public class Main {

    public static void main(String[] args) {
        SolutionShopee03 solutionShopee03 = new SolutionShopee03();
        int[] arr = {2,1,3,1,2};
        long solve = solutionShopee03.Solve3(5, arr);
        System.out.println(solve);
    }
}

class SolutionShopee03{


    /**
     * 只过了40%，哪里除了问题
     * @param n
     * @param lens
     * @return
     */
    public long Solve(int n, int[] lens) {
        // write code here
        Arrays.sort(lens);
        int ans = 0;
        for (int i = n - 1; i >= 2; --i){
            int left = 0;
            int right = i - 1;
            while(left < right){
                if(lens[left] + lens[right] > lens[i]){
                    ans += right - left;
                    --right;
                }
                else {
                    ++left;
                }
            }
        }
        return ans;
    }


    public long Solve2(int n, int[] lens) {
        // write code here
        Arrays.sort(lens);
        int ans = 0;
        for (int i = 0; i < n - 2; i++) {
            for(int j = i + 1; j < n - 1; ++j){
                int s = lens[i] + lens[j];
                int left = j + 1;
                int right = n - 1;
                while(left < right){
                    int mid = (left + right + 1) >>> 1;
                    if(lens[mid] < s){
                        left = mid;
                    }
                    else{
                        right = mid - 1;
                    }
                }
                if(lens[right] < s){
                    ans += right - j;
                }
            }
        }
        return ans;
    }

    public long Solve3(int n, int[] lens) {
        // write code here

        Arrays.sort(lens);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int kth = i;
            for (int j = i + 1; j < n; ++j){
                while(kth + 1 < n && lens[kth + 1] < lens[i] + lens[j]){
                    ++kth;
                }
                ans += Math.max(kth - j, 0);
            }
        }
        return ans;
    }

    public long Solve5(int n, int[] lens) {
        // write code here

        Arrays.sort(lens);
        int ans = 0;
        for (int i = n - 1; i  >= 2; --i) {
            int left = 0;
            int right = i - 1;
            while(left < right){
                if(lens[left] + lens[right] > lens[i]){
                    ans += (right - left);
                    right--;
                }
                else {
                    left++;
                }
            }
        }
        return ans;
    }

}
