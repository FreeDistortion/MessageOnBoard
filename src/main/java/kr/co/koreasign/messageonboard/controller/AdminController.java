package kr.co.koreasign.messageonboard.controller;

import kr.co.koreasign.messageonboard.itface.serviceITFace.MessageService;
import kr.co.koreasign.messageonboard.model.dto.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vks")
@Slf4j
public class AdminController {

    private final MessageService messageService;

    @GetMapping("/message")
    public List<Message> getMessage() {
        return messageService.getAllMessages();
    }

    @PostMapping("/add/filteredmessage")
    public ResponseEntity<?> addFilteredMessage(@RequestParam("messageId") List<Long> messageIds){
        messageService.saveFilteredMessage(
                messageService.getFilteredMessagesById(messageIds)
        );
        
        // create(save) 이후 redirect할 url 설정
        URI location = URI.create("/vks/view/mgmt");
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(location);
        return new ResponseEntity<>(headers, HttpStatus.SEE_OTHER);
    }
}
