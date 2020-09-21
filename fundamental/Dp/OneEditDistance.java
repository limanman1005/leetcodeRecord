package Dp;

/**
 * ClassName: OneEditDistance
 * Description:
 * date: 2020/9/21 17:05
 *
 * @author liyh
 */
public class OneEditDistance {
}

class Solution161 {
    /**
     * 这个就是总结了不同的情况，然后就行比较
     * @param s
     * @param t
     * @return
     */
    public boolean isOneEditDistance(String s, String t) {
        int lens = s.length();
        int lent = t.length();
        if(lent < lens){
            return isOneEditDistance(t, s);
        }
        //todo 进行更详细的分析 0921
        if(lent - lens > 1){
            return false;
        }
        for(int i = 0; i < lens; ++i){
            if(s.charAt(i) != t.charAt(i)){
                if(lens == lent){
                    return s.substring(i + 1).equals(t.substring(i + 1));
                }
                else{
                    return s.substring(i).equals(t.substring(i + 1));
                }
            }
        }
        return (lens + 1) == lent;
    }
}
