package com.typeConverter.converter;

import com.typeConverter.type.IpPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

public class IpPortToStringConverter implements Converter<IpPort,String> {
    private static final Logger log = LoggerFactory.getLogger(IpPortToStringConverter.class);

    @Override
    public String convert(IpPort source) {
    log.info("convert source ={}",source);
        return source.getIp()+":"+source.getPort();

    }
}
