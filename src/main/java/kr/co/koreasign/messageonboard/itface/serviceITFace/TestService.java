package kr.co.koreasign.messageonboard.itface.serviceITFace;

import kr.co.koreasign.messageonboard.model.dto.TestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

public interface TestService {
    ProcessBuilder executeProgram(String cmd);
    ResponseEntity<String> getJSON();
}
