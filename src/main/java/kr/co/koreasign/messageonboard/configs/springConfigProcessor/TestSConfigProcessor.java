package kr.co.koreasign.messageonboard.configs.springConfigProcessor;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "dock")
public class TestSConfigProcessor {
    private int ss;

    public void setSs(int ss) {
        this.ss = ss;
    }

    @Override
    public String toString() {
        return "TestSConfigProcessor{" +
                "ss=" + ss +
                '}';
    }

    public int getSs() {
        return ss;
    }
}
