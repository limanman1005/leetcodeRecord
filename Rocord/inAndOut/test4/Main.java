package inAndOut.test4;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 * ClassName: Main
 * Description:
 * date: 2020/9/12 20:43
 *
 * @author liyh
 */
public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        ArrayList<String> strings = new ArrayList<>();
//        strings.add("123");
//        strings.getClass().getMethod("add", Object.class).invoke(strings, 456);
        ArrayList list = new ArrayList();
        list.add(LocalDate.now());
        list.add(new Date());
    }
}
