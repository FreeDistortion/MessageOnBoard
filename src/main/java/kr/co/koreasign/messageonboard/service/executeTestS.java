package kr.co.koreasign.messageonboard.service;

import kr.co.koreasign.messageonboard.itface.serviceITFace.TestService;
import kr.co.koreasign.messageonboard.model.dto.TestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;

//@Service
@RequiredArgsConstructor
@Slf4j
public class executeTestS implements TestService {
    @Override
    public ProcessBuilder executeProgram(String cmd) {
        ProcessBuilder builder = new ProcessBuilder();
        try {
            if (System.getProperty("os.name").indexOf("Windows") > -1) {
                log.info("windows!");

                builder.command("cmd.exe", "/c", cmd);
                builder.directory(new File("/c"));
            } else {
                builder.command("sh", "-c", cmd);
                /*builder.directory(new File("/usr/local/bin/"));*/
            }
        } catch (Exception e) {
            log.info("file execution method() exception");
            e.printStackTrace();
        }
        return builder;
    }

    @Override
    public ResponseEntity<String> getJSON() {
        return null;
    }


}
