package kr.co.koreasign.messageonboard.service;

import kr.co.koreasign.messageonboard.itface.repoITFace.FilteredMessageRepo;
import kr.co.koreasign.messageonboard.itface.repoITFace.MessageRepo;
import kr.co.koreasign.messageonboard.itface.serviceITFace.MessageService;
import kr.co.koreasign.messageonboard.model.dto.FilteredMessage;
import kr.co.koreasign.messageonboard.model.dto.Message;
import kr.co.koreasign.messageonboard.model.entity.message.FilteredMessageETT;
import kr.co.koreasign.messageonboard.model.entity.message.MessageETT;
import kr.co.koreasign.messageonboard.utility.TransformationUtility;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReviewMessage implements MessageService {
    private final MessageRepo messageRepo;
    private final FilteredMessageRepo filteredMessageRepo;

    @Override
    public void saveMessage(Message message) {


        new TransformationUtility()
                .convertAtoB(
                        messageRepo.save(
                                new TransformationUtility().convertAtoB(message, MessageETT.class)
                        ),
                        Message.class
                );
    }

    @Override
    public List<Message> getAllMessages() {

        return new TransformationUtility().convertListAtoB(messageRepo.findAll(), Message.class);
    }
    @Override
    public List<FilteredMessage> getAllFilteredMessages() {
        return new TransformationUtility().convertListAtoB(filteredMessageRepo.findAll(),FilteredMessage.class);
    }
    @Override
    public void saveFilteredMessage(FilteredMessage filteredMessage) {
        new TransformationUtility()
                .convertAtoB(
                        filteredMessageRepo.save(
                                new TransformationUtility().convertAtoB(filteredMessage, FilteredMessageETT.class)
                        ),
                        FilteredMessage.class
                );
    }

    @Override
    public void saveFilteredMessage(List<FilteredMessage> filteredMessages) {
        filteredMessageRepo.saveAll(new TransformationUtility().convertListAtoB(filteredMessages, FilteredMessageETT.class));
    }



    @Override
    public List<FilteredMessage> getFilteredMessagesById(List<Long> messageIds) {
        List<FilteredMessage> filteredMessageList = new ArrayList<>();
        for(Long messageId : messageIds){
            log.info(messageId+"번째: "+messageRepo.getMessageETTById(messageId));
            filteredMessageList.add(
                    new TransformationUtility().convertAtoB(
                            messageRepo.getMessageETTById(messageId),
                            FilteredMessage.class
                            )
            );
        }
        return filteredMessageList;

    }
}
