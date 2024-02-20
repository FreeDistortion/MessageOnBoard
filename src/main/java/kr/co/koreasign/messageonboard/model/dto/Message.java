package kr.co.koreasign.messageonboard.model.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
public class Message {
    private Long id;
    private String content;
    private Long createdBy;
    private LocalDateTime createdAt;
}
