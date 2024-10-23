package hello.itemservice.web.validation.form;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class TestClass {
    @Min(value = 20)
    private int age;
    @Max(value = 50)
    private int price;

}
