package kr.co.koreasign.messageonboard.service;

import kr.co.koreasign.messageonboard.itface.repoITFace.MessageRepo;
import kr.co.koreasign.messageonboard.itface.serviceITFace.MessageService;
import kr.co.koreasign.messageonboard.model.dto.Message;
import kr.co.koreasign.messageonboard.model.entity.message.MessageETT;
import kr.co.koreasign.messageonboard.utility.TransformationUtility;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReviewMessage implements MessageService {
    private final MessageRepo messageRepo;

    @Override
    public void saveMessage(Message message) {


                new TransformationUtility().convertAtoB(
                        messageRepo.save(new TransformationUtility().convertAtoB(message, MessageETT.class)), Message.class
                );
    }

    @Override
    public List<Message> getAllMessages() {

        return
                new TransformationUtility().convertListAtoB(
                        messageRepo.findAll(), Message.class
                );
    }
}
