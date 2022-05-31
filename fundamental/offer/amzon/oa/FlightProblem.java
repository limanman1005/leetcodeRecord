package offer.amzon.oa;

import java.util.HashMap;

/**
 * ClassName: FlightProblem
 * Description:
 * date: 28/5/2022 上午9:37
 * 2. 飞机航线问题
 * 现给出一架飞机的最大飞行距离为n 如n = 7000
 * 给出一个二维数组，记录可选出发航线的ID和距离 如｛  ｛1,2000｝，｛2,3000｝，｛3,4000｝ ｝1号航线2000英里，2号航线3000英里，3号航线4000英里。
 * 再给出一个二维数组，记录可选返回航线的ID和距离 如｛  ｛7,5000｝，｛8,3000｝ ｝7号航线5000英里，8号航线3000英里。
 * 每次飞机出行必须从出发航线和返回航线中都选择一条（两种航线的选择是独立的）。出发和返回航线的总里程不能超过飞机的最大飞行距离。
 * 请返回能最大利用飞机航程的出发和返回ID。 如上述例子应返回｛｛1,7｝，｛3,8｝｝
 * @author liyh
 */
public class FlightProblem {
    public static void main(String[] args) {
        HashMap<Integer, int[]> integerHashMap = new HashMap<>();
        int[] arr = {7, 5000};
        integerHashMap.put(2000, arr);
        boolean b = integerHashMap.containsKey(2000);
        System.out.println("b = " + b);
        int[] ints = integerHashMap.get(2000);
        int[][] arr2 = {{1, 2000}, {2, 3000}, {3, 4000}};
//        Arrays.sort(arr2, (a1, a2) -> a2[1] - a1[1]);
//        System.out.println(arr2);
        int left = 0;
        int right = arr.length;
        int target = 2000;
        int closetIdx = arr2.length;
        while(left <= right){
            int mid = (left + right) >>> 1;
            if(arr2[mid][1] < target){
                left = mid + 1;
            }
            else if(arr2[mid][1] > target){
                right = mid - 1;
            }
            else if(arr2[mid][1] == target){
                closetIdx = mid;
                break;
            }
        }
        if(left > right){
            closetIdx = right;
        }
        System.out.println("closetIdx = " + closetIdx);

    }
}
