package com.typeConverter.converter;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
@Slf4j
public class StringToIntegerConverter implements Converter<String,Integer> {
    private static final Logger log = LoggerFactory.getLogger(StringToIntegerConverter.class);

    @Override
    public Integer convert(String source) {
      log.info("convert source ={}",source);
      Integer integer=Integer.valueOf(source);
        return integer;
    }
}
