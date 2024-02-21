package kr.co.koreasign.messageonboard.itface.serviceITFace;

import kr.co.koreasign.messageonboard.model.dto.FilteredMessage;
import kr.co.koreasign.messageonboard.model.dto.Message;

import java.util.List;

public interface MessageService {
    void saveMessage(Message message);
    void saveFilteredMessage(FilteredMessage filteredMessage);
    void saveFilteredMessage(List<FilteredMessage> filteredMessages);
    List<Message> getAllMessages();

    List<FilteredMessage> getAllFilteredMessages();
    List<FilteredMessage> getFilteredMessagesById(List<Long> messageIds);
}
