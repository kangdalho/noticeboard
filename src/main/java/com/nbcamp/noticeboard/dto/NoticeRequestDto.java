package com.nbcamp.noticeboard.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class NoticeRequestDto {

    @NotBlank(message = "제목을 입력해주세요.")
    private final String title;
    @NotBlank(message = "내용을 입력해주세요.")
    private final String content;
    @NotBlank(message = "작성자 이름은 필수입력사항입니다.")
    private final String author;
}
