package kr.co.koreasign.messageonboard.controller;

import kr.co.koreasign.messageonboard.itface.serviceITFace.MessageService;
import kr.co.koreasign.messageonboard.model.dto.FilteredMessage;
import kr.co.koreasign.messageonboard.model.dto.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/public")
//@CrossOrigin(origins = )
public class MessageController {

    private final MessageService messageService;


    @PostMapping("/rcvmsg")
    public void saveMessage(@RequestBody @Validated Message message) {
        messageService.saveMessage(message);
    }


    @GetMapping("/read/filteredmessage")
    public List<FilteredMessage> getFilteredMessage(){
        return messageService.getAllFilteredMessages();
    }
}