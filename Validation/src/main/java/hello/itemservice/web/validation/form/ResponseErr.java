package hello.itemservice.web.validation.form;

import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
@Getter
public class ResponseErr {

   private String message;
   private String errCode;

    public ResponseErr(String message, String errCode) {
        this.message = message;
        this.errCode = errCode;
    }
}
