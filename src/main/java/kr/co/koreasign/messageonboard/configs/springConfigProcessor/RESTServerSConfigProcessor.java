package kr.co.koreasign.messageonboard.configs.springConfigProcessor;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "target.service")
@Getter
@Setter
public class RESTServerSConfigProcessor {
    private String backurl;
    private String fronturl;
}
