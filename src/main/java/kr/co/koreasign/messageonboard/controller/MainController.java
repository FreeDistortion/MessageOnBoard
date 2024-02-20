package kr.co.koreasign.messageonboard.controller;

import kr.co.koreasign.messageonboard.configs.springConfigProc.FrontServerSConfigProcessor;
import kr.co.koreasign.messageonboard.configs.springConfigProc.ServerSConfigProcessor;
import kr.co.koreasign.messageonboard.configs.springConfigProc.TestSConfigProcessor;
import kr.co.koreasign.messageonboard.itface.serviceITFace.TestService;
import kr.co.koreasign.messageonboard.model.dto.TestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import javax.print.attribute.standard.Sides;
import java.net.URL;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MainController {

    private final ServerSConfigProcessor serverSConfigProcess;
    private final TestSConfigProcessor testSConfigProcessor;
    private final FrontServerSConfigProcessor frontServerSConfigProcessor;
    private final TestService testService;

    @GetMapping("")
    public String initPage() {
        RestTemplate restTemplate = new RestTemplate();
        String serverAddress = "http://" + serverSConfigProcess.getAddress() + ":" + serverSConfigProcess.getPort() + "/dev";

        // application.yml 파일 임의 variable 추가 test
        log.info("" + testSConfigProcessor.getSs());

        ResponseEntity<String> json = testService.getJSON();

        log.info(frontServerSConfigProcessor.getUrl());

        log.info(
                testService.getJSON().toString()
        );

        String response = restTemplate.getForObject(serverAddress, String.class);
        return response;
    }

//    @GetMapping("/login")

}
