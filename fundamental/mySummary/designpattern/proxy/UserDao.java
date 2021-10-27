package mySummary.designpattern.proxy;

/**
 * ClassName: UserDao
 * Description:
 * date: 2021/10/21 1:34
 *
 * @author liyh
 */
public class UserDao implements IUserDao{
    @Override
    public void save() {
        System.out.println("保存数据");
    }
}
