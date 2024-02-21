package kr.co.koreasign.messageonboard.controller;

import kr.co.koreasign.messageonboard.itface.serviceITFace.MessageService;
import kr.co.koreasign.messageonboard.model.dto.FilteredMessage;
import kr.co.koreasign.messageonboard.model.dto.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vks/view")
@Slf4j
public class AdminViewController {
    private final MessageService messageService;

    @GetMapping("/mgmt")
    public ModelAndView managementPage(){
        ModelAndView mav = new ModelAndView("mgmt");
        List<Message> messageList = messageService.getAllMessages();
        mav.addObject("messageList",messageList);
        return mav;

    }

    @GetMapping("/read/filteredmessage")
    public ModelAndView getFilteredMessage(){
        ModelAndView mav = new ModelAndView("filteredmessages");
        List<FilteredMessage> filteredMessageList = messageService.getAllFilteredMessages();
        mav.addObject("filteredMessageList",filteredMessageList);
        return mav;
    }
}
