package kr.co.koreasign.messageonboard.configs;

import kr.co.koreasign.messageonboard.configs.springConfigProcessor.RESTServerSConfigProcessor;
import kr.co.koreasign.messageonboard.configs.springConfigProcessor.ServerSConfigProcessor;
import kr.co.koreasign.messageonboard.configs.springConfigProcessor.TestSConfigProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SCPConfigs {
    @Bean
    public ServerSConfigProcessor serverSConfigProcess() {
        return new ServerSConfigProcessor();
    }
    @Bean
    public TestSConfigProcessor testSConfigProcess() {
        return new TestSConfigProcessor();
    }
    @Bean
    public RESTServerSConfigProcessor frontServerSConfigProcessor() {
        return new RESTServerSConfigProcessor();
    }

}
