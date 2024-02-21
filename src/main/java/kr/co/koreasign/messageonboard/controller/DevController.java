package kr.co.koreasign.messageonboard.controller;

import kr.co.koreasign.messageonboard.itface.serviceITFace.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/dev")
public class DevController {
    private final TestService testService;

    @GetMapping("")
    public String devPage(){
        return "dev/dev";
    }

    @GetMapping("/test")
    public String test(){
        testService.executeProgram("notepad.exe");
        return "test";
    }
}
