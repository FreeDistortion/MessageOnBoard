package kr.co.koreasign.messageonboard.controller;

import kr.co.koreasign.messageonboard.configs.springConfigProcessor.RESTServerSConfigProcessor;
import kr.co.koreasign.messageonboard.configs.springConfigProcessor.ServerSConfigProcessor;
import kr.co.koreasign.messageonboard.configs.springConfigProcessor.TestSConfigProcessor;
import kr.co.koreasign.messageonboard.itface.serviceITFace.MessageService;
import kr.co.koreasign.messageonboard.itface.serviceITFace.TestService;
import kr.co.koreasign.messageonboard.model.dto.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MainController {

    private final ServerSConfigProcessor serverSConfigProcess;
    private final TestSConfigProcessor testSConfigProcessor;
    private final RESTServerSConfigProcessor restServerSConfigProcessor;
    private final TestService testService;
    private final MessageService messageService;

//    @GetMapping("/test")
//    public String initPage() {
//        RestTemplate restTemplate = new RestTemplate();
//        String serverAddress = "http://" + serverSConfigProcess.getAddress() + ":" + serverSConfigProcess.getPort() + "/dev";
//
//        // application.yml 파일 임의 variable 추가 test
//        log.info("" + testSConfigProcessor.getSs());
//
//        ResponseEntity<String> json = testService.getJSON();
//
//
//        log.info(
//                testService.getJSON().toString()
//        );
//
//        String response = restTemplate.getForObject(serverAddress, String.class);
//        return response;
//    }

    @GetMapping("/")
    public ModelAndView mainPage(){
        return
                new ModelAndView("main");
    }



}
