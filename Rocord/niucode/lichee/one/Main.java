package niucode.lichee.one;

/**
 * ClassName: Main
 * Description:
 * date: 2021/10/30 14:29
 *
 * @author liyh
 */
public class Main {
    public static void main(String[] args) {
        SolutionLiZhi01 solutionLiZhi01 = new SolutionLiZhi01();
        int[] nums = {2, 1, -1};
        int i = solutionLiZhi01.pivotIndex(nums);
        System.out.println(i);
    }
}

class SolutionLiZhi01{



    public int pivotIndex(int[] num){
        if(num == null || num.length == 0){
            return -1;
        }
        int ans = -1;
        for(int i = 0; i < num.length; ++i){
            int leftSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += num[j];
            }
            int rightSum = 0;
            for (int j = i + 1; j < num.length; j++) {
                rightSum += num[j];
            }
            if(leftSum == rightSum){
                ans = i;
                break;
            }
        }
        return ans;
    }
}
