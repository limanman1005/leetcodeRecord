package niucode.yunzhi.one;


//1、 合并排序，将两个已经排序的数组合并成一个数组，其中一个数组能容下两个数组的所有元素;
//int a[]={2,4,6,8,10,0,0,0,0,0};    int b[]={1,3,5,7,9};

public class Main {

    public static void main(String[] args) {
        int a[]={2,4,6,8,10,0,0,0,0,0};
        int b[]={1,3,5,7,9};
        mergeArr(a, b);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    private static void mergeArr(int[] a, int[] b) {
        int p1 = 0;
        for (; p1 < a.length; p1++) {
            if(a[p1] == 0){
                break;
            }
        }
        p1--;
        int p2 = 0;
        for (;  p2 < b.length; p2++){
            if(b[p2] == 0){
                break;
            }
        }
        p2--;
        int p3 = a.length - 1;
        while(p1 >= 0 && p2 >= 0){
            if(a[p1] > b[p2]){
                a[p3] = a[p1];
                p1--;
                p3--;
            }
            else{
                a[p3] = b[p2];
                p2--;
                p3--;
            }
        }
        while(p2 >= 0){
            a[p3] = b[p2];
            p2--;
            p3--;
        }
    }
}
