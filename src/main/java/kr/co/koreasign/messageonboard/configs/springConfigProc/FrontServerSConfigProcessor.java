package kr.co.koreasign.messageonboard.configs.springConfigProc;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "target.service")
@Getter
@Setter
public class FrontServerSConfigProcessor {
    private String url;
    private String url2;
}
