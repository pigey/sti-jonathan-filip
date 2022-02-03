package sti.jonathan.filip.unittest;

import static org.junit.Assert.*;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sti.jonathan.filip.domain.Student;
import sti.jonathan.filip.service.SchoolService;


public class TestService {
    private static ApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("/sti-service.xml");


    private SchoolService schoolService;

    private ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    @Before
    public void before() {
        schoolService = (SchoolService) getApplicationContext().getBean("service");
    }

    @Test
    public void testAddStundent() {
        Student student = new Student("Jonathan", "Birgersson", "0204054217");
        schoolService.addStudent(student);
        assertEquals(student.getfName(), schoolService.getStudent("0204054217").getfName());
    }

}
