package hello.itemservice.web.validation.form;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final MessageSource messageSource;

    public TestController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    publi static String errorMessage(String ClassName, String method,String action1,String action2){

        return  messageSource.getMessage(ClassName+"."+method+"."+action1+".");
    }
}
