import com.sakura.pojo.User;
import com.sakura.pojo.UserExample;
import com.sakura.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBug {
    @Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/application.xml");
        UserServiceImpl userServiceImpl = (UserServiceImpl) context.getBean("UserServiceImpl");
        for (User user : userServiceImpl.queryAllUser()) {
            System.out.println(user.toString());
        }
    }
}
