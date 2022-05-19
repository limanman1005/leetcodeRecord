package niucode.jianxin.one;

/**
 * ClassName: Main
 * Description:
 * date: 2021/10/23 18:57
 *
 * @author liyh
 */
public class Main {
    public static void main(String[] args) {
        SolutionJianXin01 solutionJianXin01 = new SolutionJianXin01();
        int[] arr = {6, 3, 2,4, 3, 3, 6, 9};
        int index = solutionJianXin01.getIndex(3, 3, arr);
        System.out.println(index);

    }

}

class SolutionJianXin01{
    public int getIndex (int k, int m, int[] deliciousness) {
        // write code here
        int len = deliciousness.length;
        int ans = -1;
        for(int i = len - 1; i >= 0; --i){
            if(deliciousness[i] > m){
                if(k > 1){
                    k--;
                    continue;
                }
                else{
                    ans = i;
                    break;
                }
            }
        }
        return ans;
    }
}
