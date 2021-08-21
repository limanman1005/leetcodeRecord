package beautyOfAlgorithm.chapter7.dfs;

/**
 * ClassName: DifficultStringPractise
 * Description:
 * date: 2020/4/10 9:51
 * 从一个空串出发，如何一步步的递归实现
 * @author liyh
 */
public class DifficultStringPractise {

    private static int count;

    public static void main(String[] args) {
        dfs(3, 4, "");
    }

    private static void dfs(int width, int n, String prefix){
        for (char c = 'A'; c <= 'A' + width; ++c){
            if(isHard(prefix, c)){
                count++;
                String hardString = prefix + c;
                System.out.println(hardString);
                if(count == n){
                    System.exit(0);
                }
                dfs(width, n, hardString);
            }
        }
    }



    private static boolean isHard(String prefix, char i) {
        //这个是宽度。一开始为0
        int count = 0;
        //一开始比较后一个字符，后两个字符，所以j需要减2
        for(int j = prefix.length() - 1; j >=0; j-=2){
            //从prefix后面截取一部分东西
            final String s1 = prefix.substring(j, j + count + 1);
            //需要加上的字符和prefix上截取的一部分组合
            final String s2 = prefix.substring(j + count + 1) + i;
            if(s1.equals(s2)){
                return false;
            }
            count++;
        }
        return true;
    }
}
