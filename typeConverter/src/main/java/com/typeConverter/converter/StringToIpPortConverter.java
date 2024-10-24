package com.typeConverter.converter;

import com.typeConverter.type.IpPort;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
@Slf4j
public class StringToIpPortConverter implements Converter<String, IpPort> {

    private static final Logger log = LoggerFactory.getLogger(StringToIpPortConverter.class);

    public IpPort convert(String source){
        log.info("convert source={}",source);
        String[] split = source.split(":");
        String ip=split[0];
        int port= Integer.parseInt(split[1]);


        return  new IpPort(ip,port);
    }
}
