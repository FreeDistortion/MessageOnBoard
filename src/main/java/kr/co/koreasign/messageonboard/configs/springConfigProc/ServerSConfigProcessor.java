package kr.co.koreasign.messageonboard.configs.springConfigProc;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "server")
public class ServerSConfigProcessor {


    private String address;
    private int port;


    public String getAddress() {
        return address;
    }

    public int getPort() {
        return port;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
