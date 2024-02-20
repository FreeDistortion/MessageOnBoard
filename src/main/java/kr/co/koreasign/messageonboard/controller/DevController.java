package kr.co.koreasign.messageonboard.controller;

import kr.co.koreasign.messageonboard.itface.serviceITFace.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class DevController {
    private final TestService testService;

    @GetMapping("/dev")
    public String devPage(){
        return "dev/dev";
    }

    @GetMapping("/test")
    public String test(){
        testService.executeProgram("notepad.exe");
        return "test";
    }
}
