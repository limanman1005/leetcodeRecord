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
        //这种手法确保s的长度小于等于t
        if(lent < lens){
            return isOneEditDistance(t, s);
        }
        //todo 进行更详细的分析 0921
        //以下其实就是分类讨论，当长度相差超过一的时候是无论如何都不能只变一次
        if(lent - lens > 1){
            return false;
        }
        //剩下的就是对较短的字符串进行遍历。
        for(int i = 0; i < lens; ++i){
            if(s.charAt(i) != t.charAt(i)){
                //如果碰到不相等的直接判断下剩下的字符串相不相等
                //并且两者长度相等，那么判断剩下的子串相不相等。相当于替换
                if(lens == lent){
                    return s.substring(i + 1).equals(t.substring(i + 1));
                }
                //否则的话就是删除t的一个字符串判断下相不相等
                else{
                    return s.substring(i).equals(t.substring(i + 1));
                }
            }
        }
        //最后这个情况就是s串需要加一个字符串
        return (lens + 1) == lent;
    }
}
