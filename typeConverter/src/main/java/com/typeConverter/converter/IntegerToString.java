package com.typeConverter.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

public class IntegerToString implements Converter<Integer,String> {

    private static final Logger log = LoggerFactory.getLogger(IntegerToString.class);

    @Override
    public String convert(Integer source) {
        log.info("convert toString ={}",source);
        return String.valueOf(source);
    }
}
