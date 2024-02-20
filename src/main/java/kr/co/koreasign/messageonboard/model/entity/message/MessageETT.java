package kr.co.koreasign.messageonboard.model.entity.message;

import jakarta.persistence.*;
import kr.co.koreasign.messageonboard.model.dto.Message;
import kr.co.koreasign.messageonboard.model.entity.MetaData;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table
@Builder
public class MessageETT extends MetaData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;

    public void setContent(String content) {
        this.content = content;
    }
}
