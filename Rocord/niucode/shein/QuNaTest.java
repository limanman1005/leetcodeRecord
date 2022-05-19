package niucode.shein;

import java.util.*;

/**
 * ClassName: QuNaTest
 * Description:
 * date: 2021/10/13 15:22
 *
 * @author liyh
 */
public class QuNaTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Solution3 solution3 = new Solution3();
        String ans = solution3.getListResult(str);
        System.out.println(ans);
    }

}

class Solution1{

    public String reorder(String str){
        if(str == null){
            return null;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        for(int i = 0; i < chars.length; ++i){
            if(map.containsKey(chars[i])){
                map.put(chars[i], map.get(chars[i]) + 1);
            }
            else {
                map.put(chars[i], 1);
            }
        }
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        ArrayList<MyChar> myCharList = new ArrayList<>(entries.size());
        for (Map.Entry entry : entries){
            myCharList.add(new MyChar((Character) entry.getKey(), (Integer) entry.getValue()));
        }
        Collections.sort(myCharList, (o1, o2)->{
            if(o1.count != o2.count){
                return o2.count - o1.count;
            }
            else if(o1.ch.charValue() != o2.ch.charValue()){
                return o1.ch.charValue() - o2.ch.charValue();
            }
            else{
                return o2.ch.charValue() - o1.ch.charValue();
            }
        });
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < myCharList.size(); i++) {
            MyChar myChar = myCharList.get(i);
            for(int j = 0; j < myChar.count; ++j){
                stringBuilder.append(myChar.ch);
            }
        }
        return stringBuilder.toString();
    }

    class MyChar{
        private Character ch;
        private int count;

        public MyChar(Character ch, int count){
            this.ch = ch;
            this.count = count;
        }

    }

}

class Solution2{

    private Map<Character, Integer> map = new HashMap<Character, Integer>(){
        {
            put('-', 1);
            put('+', 1);
            put('*', 2);
            put('/', 2);
        }
    };

    public String getListResult(String str){
        str.replaceAll(" ", "");
        char[] chars = str.toCharArray();
        int len = chars.length;
        LinkedList<Integer> numStack = new LinkedList<>();
        LinkedList<Character> opStack = new LinkedList<>();
        numStack.add(0);
        for(int i = 0; i < len; ++i){
            if(chars[i] == '('){
                opStack.addLast(chars[i]);
            }
            else if(chars[i] == ')'){
                while (!opStack.isEmpty()){
                    if(opStack.peekLast() != '('){
                        int state = helper(numStack, opStack);
                        if(state == 1){
                            return "division by zero";
                        }
                    }
                    else{
                        opStack.pollLast();
                        break;
                    }
                }
            }
            else{
                if(Character.isDigit(chars[i])){
                    int curNum = 0;
                    int j = i;
                    while(j < len && Character.isDigit(chars[j])){
                        curNum = curNum * 10 + chars[i] - '0';
                        j++;
                    }
                    numStack.addLast(curNum);
                    i = j - 1;
                }
                else{
                    if(i > 0 && (chars[i -1] == '(' || chars[i - 1] == '+' ||chars[i - 1] == '-')){
                        numStack.addLast(0);
                    }
                    while (!opStack.isEmpty() && opStack.peekLast() != '('){
                        char pre = opStack.peekLast();
                        if(map.get(pre) >= map.get(chars[i])){
                            int state = helper(numStack, opStack);
                            if(state == 1){
                                return "division by zero";
                            }
                        }
                        else{
                            break;
                        }
                    }
                    opStack.addLast(chars[i]);
                }
            }
        }
        while (!opStack.isEmpty()){
            int state = helper(numStack, opStack);
            if(state == 1){
                return "division by zero";
            }
        }
        return String.valueOf(numStack.peekLast());
    }

    private int helper(LinkedList<Integer> numStack, LinkedList<Character> opStack) {
        return 0;
    }
}
class Solution3{
    private Map<String, Integer> map = new HashMap<String, Integer>(){
        {
            put("-", 1);
            put("+", 1);
            put("*", 2);
            put("/", 2);
        }
    };

    public String getListResult(String str){
        String[] s = str.split(" ");
        LinkedList<Integer> numStack = new LinkedList<>();
        LinkedList<String> opsStack = new LinkedList<>();
        numStack.add(0);
        String str2 = "1";
        for(int i = 0; i < s.length; ++i){
            if(checkCharacter(s[i])){
                if("(".equals(s[i])){
                    opsStack.addLast(s[i]);
                }
                else if(")".equals(s[i])){
                    while (!opsStack.isEmpty()){
                        if(!opsStack.peekLast().equals("(")){
                            int state = helper(numStack, opsStack);
                            if(state == 1){
                                return "division by zero";
                            }
                        }
                        else{
                            opsStack.pollLast();
                            break;
                        }
                    }
                }
                else{
                    while (!opsStack.isEmpty() && !opsStack.peekLast().equals("(")){
                        String pre = opsStack.peekLast();
                        if(map.get(pre) >= map.get(s[i])){
                            int state = helper(numStack, opsStack);
                            if(state == 1){
                                return "division by zero";
                            }
                        }
                        else{
                            break;
                        }
                    }
                    opsStack.addLast(s[i]);
                }
            }
            else{
                int curNum = Integer.parseInt(s[i]);
                numStack.addLast(curNum);
            }

        }
        while (!opsStack.isEmpty()){
            int state = helper(numStack, opsStack);
            if(state == 1){
                return "division by zero";
            }
        }
        return String.valueOf(numStack.peekLast());
    }

    private boolean checkCharacter(String s) {
        if(s.length() == 1){
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("(") || s.equals(")")){
                return true;
            }
        }
        return false;
    }

    private int helper(LinkedList<Integer> numStack, LinkedList<String> opStack) {
        if(numStack.isEmpty() || numStack.size() < 2 || opStack.isEmpty()){
            return 2;
        }
        int val1 = numStack.pollLast();
        int val2 = numStack.pollLast();
        String op = opStack.pollLast();
        int ans = 0;
        if("+".equals(op)){
            ans = val1 + val2;
        }
        else if("-".equals(op)){
            ans = val2 - val1;
        }
        else if("/".equals(op)){
            if(val1 == 0){
                return 1;
            }
            else{
                ans = val2 / val1;
            }
        }
        else if("*".equals(op)){
            ans = val1 * val2;
        }
        return ans;
    }


}
