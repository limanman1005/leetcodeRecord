package niucode.yunzhi;

import java.util.*;

/**
 * ClassName: Main
 * Description:
 * date: 2021/10/12 0:14
 *
 * @author liyh
 */
public class Main {

    public static void main(String[] args) {
        String input = "[1,0,1,1]";
        String rules = "[10,2,5]";
        Main main = new Main();
        int check = main.check(input, 1, rules);
        System.out.println(check);
    }
    /* Write Code Here */
    public int check(String input, int rule_cnt, String rules) {
        String instr = input.substring(1, input.length() - 1);
        String[] instrArr = instr.split(",");
        ArrayList<Integer> pubArray = new ArrayList<>();
        for (int i = 0; i < instrArr.length; i++) {
            pubArray.add(Integer.parseInt(instrArr[i]));
        }
        String ruleStr = rules.substring(1, rules.length() - 1);
        ArrayList<Integer> ruleNumArray = new ArrayList<>();
        String[] ruleSplit = ruleStr.split(",");
        for (int i = 0; i < ruleSplit.length; i++) {
            ruleNumArray.add(Integer.parseInt(ruleSplit[i]));
        }
        int windowWidth = ruleNumArray.get(0);
        int allowNum = ruleNumArray.get(1);
        int forbidSecond = ruleNumArray.get(2);
        int pubNum = 0;
        int forbidNum = 0;
        for(int i = 0; i < pubArray.size(); i++){
            int width = i + windowWidth;
            while(i < width && i < pubArray.size()){
                if(pubArray.get(i) == 1){
                    pubNum++;
                    boolean flag = false;
                    if(pubNum >= allowNum){
                        for(int j = i + 1; j < i + forbidSecond; ++j){
                            forbidNum++;
                        }
                        pubNum = 0;
                        i = i + forbidSecond;
                        flag = true;
                        break;
                    }
                    if(flag){
                        break;
                    }
                    i++;
                }
                i++;
            }
        }
        return forbidNum;
    }


    public void backUp(){
//        while (right < pubArray.size()){
//            if(pubArray.get(right) == 1){
//                pubNum++;
//                if(pubNum >= allowNum){
//                    for(int i = right; i < pubArray.size() && i < right + windowWidth; ++i){
//                        forbidNum++;
//                    }
//                    left = right + windowWidth;
//                    right = left;
//                    pubNum = 0;
//                }
//            }
//            right++;
//        }

    }

}
