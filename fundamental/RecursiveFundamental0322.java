/**
 * ClassName: RecursiveFundamental0322
 * Description:
 * date: 2020/3/22 0:08
 *
 * @author liyh
 */
public class RecursiveFundamental0322 {
    /**
     * hanoi塔的问题
     * @param n
     * @param from
     * @param help
     * @param to
     */
    public static void hanoi(int n , String from, String help, String to){
        if(n == 1){
            System.out.println(n +" " + from + "->" + to);
            return;
        }
        hanoi(n-1, from, to, help);
        System.out.println(n + " " + from + "->" + to);
        hanoi(n-1, help, from, to);
    }


    public static int binarySearchR(int[] arr, int left, int right, int target){
        if(left > right){
            return -1;
        }
        int mid = left + (right - left)/2;
        if(arr[mid] < target){
            return binarySearchR(arr, mid+1, right, target);
        }
        else if(arr[mid] > target){
           return binarySearchR(arr, left, mid-1, target);
        }
        else{
            return mid;
        }
    }

    /**
     * 小白走楼梯经典问题
     * @param n
     * @return
     */
    public static int stairs(int n){
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        if(n == 3){
            return 4;
        }
        return stairs(n - 1) + stairs(n - 2) + stairs(n - 3);
    }

    /**
     * 细节不直观啊，我还是无法理解什么时候可以避免死循环
     * @param num
     * @return
     */
    public static int rotateArrMin(int[] num){
        int left = 0;
        int right = num.length - 1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(num[mid] < num[left]){
                right = mid;
            }
            else{
                left = mid;
            }
        }
        return left + 1;
    }

    /**
     * 二分的细节啊，我并不知道这个应该怎么做啊。
     * @param arr
     * @param left
     * @param right
     * @param target
     * @return
     */
    public static int binarySearch(int[] arr, int left, int right, int target){
        int lp = left;
        int rp = right;
        while(lp < rp){
            int mid = lp + (rp - lp)/2;
            if(arr[mid] < target){
                lp = mid;
            }
            else if(arr[mid] > target){
                rp = mid;
            }
            else{
                return mid;
            }
        }
        return arr[lp] == target? lp: -1;
    }


    /**
     * 快速幂
     * @param a
     * @param n
     * @return
     */
    public static int pow(int a, int n){
        if(n == 0){
            return 1;
        }
        int res = a;
        int ex = 1;
        while((ex << 1) <= n){
            res = res * res;
            ex = ex << 1;
        }
        return res * pow(a, n - ex);
    }

    /**
     * 插入排序的递归版本，加深对递归的理解还是不错的。
     * @param arr
     * @param n
     */
    public static void insertSortR(int[] arr, int n){
        if(n == 0){
            return;
        }
        insertSortR(arr, n-1);
        int index = n - 1;
        int value = arr[n];
        while(index >= 0 && arr[index] > value){
            arr[index + 1] = arr[index];
            index--;
        }
        arr[index + 1] = value;
    }

    public static int quickPow(int a, int n){
        if(n == 0){
            return 1;
        }
        int ans = a;
        int e = 1;
        while((e << 1) <= n){
            ans *= ans;
            e <<=1;
        }
        return ans * quickPow(a, n - e);
    }

    public static void printfArrReverse(char[] arr, int cur){
        if (cur == arr.length){
            return;
        }
        printfArrReverse(arr, cur + 1);
        System.out.println(arr[cur]);
    }



    public static void main(String[] args) {
//        hanoi(3, "start", "help", "end");
//        System.out.println("========================================");
//        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
//        System.out.println(binarySearchR(arr, 0, 9, 89));
//        int[] arr={4, 5, 6,  1, 2, 3};
//        int ans = rotateArrMin(arr);
//        System.out.println(ans);
//        System.out.println(arr[ans]);
//        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int ans = binarySearch(arr, 0, 9, 8);
//        System.out.println(ans);
//        int[] arr = {3, 1, 5, 2};
//        insertSortR(arr, arr.length-1);
//        for (int i : arr){
//            System.out.println(i);
//        }
        char[] arr = new char[]{'1', '2', '3'};
        printfArrReverse(arr, 0);
    }
}