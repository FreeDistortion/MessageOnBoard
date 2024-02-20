package kr.co.koreasign.messageonboard.itface.serviceITFace;

import kr.co.koreasign.messageonboard.model.dto.Message;

import java.util.List;

public interface MessageService {
    void saveMessage(Message message);

    List<Message> getAllMessages();


}
