package com.nbcamp.noticeboard.dto;

import com.nbcamp.noticeboard.entity.Notice;
import lombok.Getter;
import lombok.RequiredArgsConstructor;



@Getter
@RequiredArgsConstructor
public class NoticeResponseDto {

    private final Long id;

    private final String title;

    private final String content;

    private final String author;


    public static NoticeResponseDto toDto(Notice notice) {
        return new NoticeResponseDto(notice.getId(), notice.getTitle(), notice.getContent(), notice.getAuthor());
    }

}
