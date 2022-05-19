package niucode.Zoom.two;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * ClassName: Main
 * Description:
 * date: 2021/10/23 10:35
 *
 * @author liyh
 */
public class Main {

    public static void main(String[] args) {
        SolutionZoom2 solutionZoom2 = new SolutionZoom2();
        int[] arr = {1, 2, 3, 1,2, 3};
        ArrayList<ArrayList<Integer>> arrayLists = solutionZoom2.threeSums2(arr, 6);
        for (int i = 0; i < arrayLists.size(); i++) {
            System.out.println(arrayLists.get(i));
        }
    }
}

class SolutionZoom2{
    public ArrayList<ArrayList<Integer>> threeSums (int[] nums, int target) {
        // write code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if(nums == null || len < 3){
            return ans;
        }
        boolean[] visited = new boolean[len];
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if(nums[i] > target){
                break;
            }
            int left = i + 1;
            int right = len - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == target && !visited[left] && !visited[right] && !visited[i]){
                    ArrayList<Integer> integers = new ArrayList<>();
                    integers.add(nums[i]);
                    integers.add(nums[left]);
                    integers.add(nums[right]);
                    ans.add(integers);
                    left++;
                    right--;
                }
                else if(sum < 0){
                    left++;
                }
                else if(sum > 0){
                    right--;
                }
            }
        }
        return ans;
    }

    public ArrayList<ArrayList<Integer>> threeSums2 (int[] nums, int target) {
        // write code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if(nums == null || len < 3){
            return ans;
        }
        boolean[] visited = new boolean[len];
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; ++j){
                for (int k = j + 1; k < len; ++k){
                    if(nums[i] + nums[j] + nums[k] == target){
                        ArrayList<Integer> integers = new ArrayList<>();
                        if(!visited[i] && !visited[j] && visited[k]){
                            integers.add(nums[i]);
                            integers.add(nums[j]);
                            integers.add(nums[k]);
                            visited[i] = true;
                            visited[j] = true;
                            visited[k] = true;
                            ans.add(integers);
                        }
                    }
                }
            }
        }
        return ans;
    }
}
