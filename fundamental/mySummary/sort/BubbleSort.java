package mySummary.sort;

/**
 * ClassName: BubbleSort
 * Description:
 * date: 2021/11/1 23:14
 *
 * @author liyh
 */
public class BubbleSort {

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] arr = {3,1, 5, 2,4};
        bubbleSort.bubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("i = " + i);
        }
    }

    public void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; ++j){
                if(arr[i]  > arr[j]){
                    swap(arr, i, j);
                }
            }
        }
    }

    public void realBubbleSort(int[] arr){

    }


    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
