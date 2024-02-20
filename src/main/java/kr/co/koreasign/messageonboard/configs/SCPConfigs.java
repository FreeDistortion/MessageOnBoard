package kr.co.koreasign.messageonboard.configs;

import kr.co.koreasign.messageonboard.configs.springConfigProc.FrontServerSConfigProcessor;
import kr.co.koreasign.messageonboard.configs.springConfigProc.ServerSConfigProcessor;
import kr.co.koreasign.messageonboard.configs.springConfigProc.TestSConfigProcessor;
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
    public FrontServerSConfigProcessor frontServerSConfigProcessor() {
        return new FrontServerSConfigProcessor();
    }

}
