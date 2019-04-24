package spring.sources.chapter2;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import static org.junit.Assert.assertEquals;

@SuppressWarnings("deprecation")
public class BeanFactoryTest {
    @Test
    public void testSimpleLoad(){
        // 读取配置文件，反射实例化
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("spring/beanFactoryTest.xml"));
        MyTestBean myTestBean = (MyTestBean) bf.getBean("myTestBean");
        assertEquals("testStr",myTestBean.getTestStr());
    }
}
