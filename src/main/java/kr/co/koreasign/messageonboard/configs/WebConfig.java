package kr.co.koreasign.messageonboard.configs;

import kr.co.koreasign.messageonboard.configs.springConfigProcessor.RESTServerSConfigProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {
    private final RESTServerSConfigProcessor restServerSConfigProcessor;
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(restServerSConfigProcessor.getBackurl())
                .allowedOrigins(restServerSConfigProcessor.getFronturl())
                .allowedMethods("GET","POST")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
