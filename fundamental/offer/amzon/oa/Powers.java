package offer.amzon.oa;

/**
 * ClassName: Powers
 * Description:
 * date: 28/5/2022 上午11:26
 *
 * @author liyh
 */
public class Powers {
}

class SolutionPowers{

    public int powers(int[] arr1, int[] arr2){
        int length = arr1.length;
        int[] processPowers = {2, 1, 3, 4, 5};
        int[] bootingPowers = {1, 2, 6, 3, 4};
        int[] arr =new int[length+1];
        for(int i = 0 ; i < length;i++){
            arr[i+1] = arr[i]+processPowers[i];
        }
        int max = 25;
        int ans = 0;
        for(int i = 0 ; i < length;i++){
            int m = bootingPowers[i];
            for(int j = i;j<length;j++){
                int sum = arr[j+1] - arr[i];
                int count = j-i+1;
                m = Math.max(m,bootingPowers[j]);
                int s = sum*count+m;
                if(s>=max){
                    break;
                }
                ans = Math.max(ans,count);
            }
        }
        return ans;
    }

}

