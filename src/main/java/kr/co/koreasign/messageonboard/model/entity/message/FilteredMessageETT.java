package kr.co.koreasign.messageonboard.model.entity.message;


import jakarta.persistence.*;
import kr.co.koreasign.messageonboard.model.entity.MetaData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table
@Builder
public class FilteredMessageETT extends MetaData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;

    public void setContent(String content) {
        this.content = content;
    }
}
