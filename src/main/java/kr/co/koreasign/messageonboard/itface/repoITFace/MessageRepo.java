package kr.co.koreasign.messageonboard.itface.repoITFace;

import kr.co.koreasign.messageonboard.model.entity.message.MessageETT;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<MessageETT,Long> {
    MessageETT getMessageETTById(Long id);
}
