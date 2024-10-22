package hello.itemservice.mesage;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;

import java.util.Locale;

@SpringBootTest
public class MessageSourceTest {

    @Autowired
    MessageSource messageSource;


    @Test
    void helloTest(){
        String hello = messageSource.getMessage("hello", null, null);
        Assertions.assertThat(hello).isEqualTo("안녕");
    }


    @Test
    void helloEnTest(){
        String hello = messageSource.getMessage("hello", null, Locale.ENGLISH);
        Assertions.assertThat(hello).isEqualTo("hello");
    }

    @Test
    void hellossEnTest(){
        String hello = messageSource.getMessage("hello.name", new Object[]{"sssssss"}, Locale.ENGLISH);
        System.out.println(hello);
    }


    @Test
    void defalue(){
        String hello = messageSource.getMessage("af" ,null,"기본", Locale.ENGLISH);
        System.out.println(hello);
    }

    @Test
    void dsefalue(){
        String hello = messageSource.getMessage("hello" ,null,"기본", null);
        Assertions.assertThat(hello).isEqualTo("안녕");

        String hello2 = messageSource.getMessage("hello" ,null,"기본", Locale.KOREA);
        Assertions.assertThat(hello2).isEqualTo("안녕");

        String hello3 = messageSource.getMessage("hello" ,null,"기본", Locale.ENGLISH);
        Assertions.assertThat(hello3).isEqualTo("hello");
    }

}
