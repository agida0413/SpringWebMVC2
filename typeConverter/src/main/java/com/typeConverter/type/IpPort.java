package com.typeConverter.type;

import lombok.EqualsAndHashCode;
import lombok.Getter;


@EqualsAndHashCode
public class IpPort {

    private String ip;

    public int getPort() {
        return port;
    }

    public String getIp() {
        return ip;
    }

    private int port;

    public IpPort(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }
}
