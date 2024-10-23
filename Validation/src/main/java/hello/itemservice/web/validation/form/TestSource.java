package hello.itemservice.web.validation.form;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;


@Component
public class TestSource {

    @Autowired
    public TestSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    private final MessageSource messageSource;


    public  String errorMessage(String objectName,String action1,String action2){
        String msg=null;
        if(action2==null){
            msg = messageSource.getMessage(objectName+"."+action1,null,null);
        }
        else{
            msg =messageSource.getMessage(objectName+"."+action1+"."+action2,null,null);
        }


        return  msg;
    }

}
