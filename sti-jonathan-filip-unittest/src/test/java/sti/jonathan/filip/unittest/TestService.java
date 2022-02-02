package sti.jonathan.filip.unittest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sti.jonathan.filip.domain.Student;
import sti.jonathan.filip.service.impl.SchoolService;

public class TestService {

    ApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("classpath:sti-service.xml");

    private SchoolService schoolService;

    private ApplicationContext getApplicationContext() {
        return applicationContext;
    }
    @Before
    public void before() {
        schoolService = (SchoolService) getApplicationContext().getBean("service");
    }

    @Test
    public void testAddStundent(){
        Student student = new Student("Jonathan", "Birgersson" , "0204054217" );
        schoolService.addStudent(student);
    }
}
