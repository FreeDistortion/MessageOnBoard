package kr.co.koreasign.messageonboard.configs;

import kr.co.koreasign.messageonboard.configs.springConfigProc.FrontServerSConfigProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {
    private final FrontServerSConfigProcessor frontServerSConfigProcessor;
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(frontServerSConfigProcessor.getUrl())
                .allowedOrigins(frontServerSConfigProcessor.getUrl2())
                .allowedMethods("GET","POST")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
