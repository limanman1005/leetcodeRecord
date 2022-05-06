package offer;

/**
 * ClassName: CheckInclusion
 * Description:
 * date: 29/4/2022 上午10:55
 *
 * @author liyh
 */
public class CheckInclusion {

    public static void main(String[] args) {
        SolutionOffer014And567 solutionOffer014And567 = new SolutionOffer014And567();
        String s1 = "ab";
        String s2 = "cdab";
        boolean checkInclusion = solutionOffer014And567.checkInclusion2(s1, s2);
        System.out.println("checkInclusion = " + checkInclusion);
    }
}

class SolutionOffer014And567{
    //首先考虑暴力算法，求出s1所有的字符串，然后使用字符串匹配算法。
    //然后才考虑到count数组的算法
    public boolean checkInclusion(String s1, String s2) {
        if(s1 == null || s2 == null){
            return false;
        }
        if(s1.length() > s2.length()){
            return false;
        }
        int[] counts = new int[26];
        for(int i = 0; i < s1.length(); ++i){
            counts[s1.charAt(i) - 'a']++;
            counts[s2.charAt(i) - 'a']--;
        }
        if(areAllZero(counts)){
            return true;
        }
        //关键一点是需要恢复之前的记录。
        for(int i = s1.length(); i < s2.length(); ++i){
            counts[s2.charAt(i) - 'a']--;
            counts[s2.charAt(i - s1.length()) - 'a']++;
            if(areAllZero(counts)){
                return true;
            }
        }
        return false;
    }


    private boolean areAllZero(int[] counts){
        for(int num : counts){
            if(num != 0){
                return false;
            }
        }
        return true;
    }


    /**
     * 这个写法有点难看啊，说实话，特殊判断太多了。
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion2(String s1, String s2) {
        if(s1 == null || s2 == null){
            return false;
        }
        if(s1.length() > s2.length()){
            return false;
        }
        int[] counts = new int[26];
        for(int i = 0; i < s1.length(); ++i){
            counts[s1.charAt(i) - 'a']++;
        }
        int left = 0;
        int right = 0;
        while(right < s2.length()){
            if(right - left < s1.length()){
                counts[s2.charAt(right) - 'a']--;
                right++;
                if(areAllZero(counts)){
                    return true;
                }
            }
            else{
                counts[s2.charAt(left) - 'a']++;
                counts[s2.charAt(right) - 'a']--;
                if(areAllZero(counts)){
                    return true;
                }
                left++;
                right++;
            }
        }
        return false;
    }
}
