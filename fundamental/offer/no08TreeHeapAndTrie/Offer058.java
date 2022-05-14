package offer.no08TreeHeapAndTrie;

import java.util.Map;
import java.util.TreeMap;

/**
 * ClassName: Offer058
 * Description:
 * date: 14/5/2022 下午5:00
 *
 * @author liyh
 */
public class Offer058 {
}
class MyCalendar {

    private TreeMap<Integer, Integer> events;

    public MyCalendar() {
        events = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        //事件的start大于要添加start的第一个事件
        Map.Entry<Integer, Integer> event = events.floorEntry(start);
        //该事件的end要大于start
        if(event != null && event.getValue() > start){
            return false;
        }
        //第一个事件的start小于start的事件
        event = events.ceilingEntry(start);
        //比start小的第一个事件的开始始前要小于end
        if(event != null && event.getKey() < end){
            return false;
        }
        events.put(start, end);
        return true;
    }
}
