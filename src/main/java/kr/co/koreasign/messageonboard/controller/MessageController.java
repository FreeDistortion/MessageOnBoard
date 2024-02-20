package kr.co.koreasign.messageonboard.controller;

import kr.co.koreasign.messageonboard.itface.serviceITFace.MessageService;
import kr.co.koreasign.messageonboard.model.dto.Message;
import kr.co.koreasign.messageonboard.model.entity.message.MessageETT;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vks")
@Slf4j
//@CrossOrigin(origins = )
public class MessageController {

    private final MessageService messageService;

    @PostMapping("/rcvmsg")
    public void sendMessage(@RequestBody @Validated Message message) {
        messageService.saveMessage(message);
    }

    @GetMapping("/message")
    public List<Message> getMessage() {
        return messageService.getAllMessages();
    }


}