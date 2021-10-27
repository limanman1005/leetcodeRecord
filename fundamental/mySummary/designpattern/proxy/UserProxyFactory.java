package mySummary.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ClassName: UserProxyFactory
 * Description:
 * date: 2021/10/21 1:35
 * https://segmentfault.com/a/1190000011291179
 *
 * @author liyh
 */
public class UserProxyFactory {

    private Object target;

    public UserProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("开启事务");
                Object returnValue = method.invoke(target, args);
                System.out.println("提交事务");
                return null;
            }
        });
    }
}
