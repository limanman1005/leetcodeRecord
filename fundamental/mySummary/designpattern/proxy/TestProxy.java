package mySummary.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ClassName: TestProxy
 * Description: 动态创建proxy.
 * date: 2021/10/21 1:40
 *
 * @author liyh
 */
public class TestProxy {
//    public static void main(String[] args) {
//        UserDao userDao = new UserDao();
//        System.out.println(userDao.getClass());
//        IUserDao proxyInstance = (IUserDao) new UserProxyFactory(userDao).getProxyInstance();
//        System.out.println(proxyInstance.getClass());
//        proxyInstance.save();
//    }

    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        IUserDao proxyInstance = (IUserDao)Proxy.newProxyInstance(userDao.getClass().getClassLoader(), userDao.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("开启事务");
                Object returnValue = method.invoke(userDao, args);
                System.out.println("提交事务");
                return null;
            }
        });
        proxyInstance.save();

    }
}
