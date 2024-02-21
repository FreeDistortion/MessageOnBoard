package kr.co.koreasign.messageonboard.model.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
public class FilteredMessage {
    private Long id;
    private String content;
    private LocalDateTime createdAt;
}
