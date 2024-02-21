package kr.co.koreasign.messageonboard.itface.repoITFace;

import kr.co.koreasign.messageonboard.model.entity.message.FilteredMessageETT;
import kr.co.koreasign.messageonboard.model.entity.message.MessageETT;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilteredMessageRepo  extends JpaRepository<FilteredMessageETT,Long> {
    FilteredMessageETT getFilteredMessageETTById(Long id);
}
