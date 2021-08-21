package explore.juniorAlgorithm.Math;

/**
 * ClassName: RomanToInt
 * Description: 给一个罗马的数字转int
 * date: 2020/6/19 18:30
 *
 * @author liyh
 */
public class RomanToInt {
}
class Solution13 {
    /**
     * 这题的思路可以记一下的
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        int[] map = new int[26];
        fillMap(map);
        int sum = 0;
        int preNum = map[s.charAt(0) - 'A'];
        for(int i = 1; i < s.length(); ++i){
            int num = map[s.charAt(i) - 'A'];
            if(preNum < num){
                sum -= preNum;
            }
            else{
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }
    private void fillMap(int[] map){
        map['I' - 'A'] = 1;
        map['V' - 'A'] = 5;
        map['X' - 'A'] = 10;
        map['L' - 'A'] = 50;
        map['C' - 'A'] = 100;
        map['D' - 'A'] = 500;
        map['M' - 'A'] = 1000;
    }
}
