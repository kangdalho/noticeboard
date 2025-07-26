package com.nbcamp.noticeboard.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UpdateRequestDto {

    private final String title;

    private final String content;

}
