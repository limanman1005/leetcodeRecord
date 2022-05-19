package niucode.practise;

import java.util.HashMap;
import java.util.HashSet;

/**
 * ClassName: Main
 * Description:
 * date: 2021/10/17 20:50
 *
 * @author liyh
 */
public class Main {

    public static void main(String[] args) {

        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("1", "1");

        System.out.println(tableSizeFor(8));
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n;
    }
}
