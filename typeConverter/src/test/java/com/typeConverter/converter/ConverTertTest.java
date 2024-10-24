package com.typeConverter.converter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConverTertTest {

@Test
    void stringToInteger(){
    StringToIntegerConverter stringToIntegerConverter = new StringToIntegerConverter();
    Integer convert = stringToIntegerConverter.convert("10");
    Assertions.assertThat(convert).isEqualTo(10);

}


}
