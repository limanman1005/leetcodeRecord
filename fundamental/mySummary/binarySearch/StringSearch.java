package mySummary.binarySearch;

/**
 * ClassName: StringSearch
 * Description:
 * date: 2020/4/22 11:25
 *
 * @author liyh
 */
public class StringSearch {
    public static void main(String[] args) {
        String[] test = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};

//        System.out.println("a".compareTo("c"));
//
//        System.out.println("D".compareTo("e"));

        System.out.println("a".compareTo("c"));

//        System.out.println(new SolutionString().findString(test, "ball"));
    }
}


class SolutionString {
    public int findString(String[] words, String s) {
        int len = words.length;
        if(len == 0){
            return -1;
        }
        int left = 0;
        int right = len - 1;
        while(left <= right){
            if(words[left].equals("")){
                left++;
                continue;
            }
            if(words[right].equals("")){
                right--;
                continue;
            }
            int mid = (left + right) >>> 1;
            while(words[mid].equals("")){
                mid++;
                if(mid == right){
                    right = (left + right) >>> 1;
                    continue;
                }
            }
            if(words[mid].equals(s)){
                return mid;
            }
            else if(words[mid].compareTo(s) > 0){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return -1;
    }
}
