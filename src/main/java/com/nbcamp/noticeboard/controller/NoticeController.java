package com.nbcamp.noticeboard.controller;


import com.nbcamp.noticeboard.dto.NoticeRequestDto;
import com.nbcamp.noticeboard.dto.NoticeResponseDto;
import com.nbcamp.noticeboard.dto.UpdateRequestDto;
import com.nbcamp.noticeboard.service.NoticeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notice")
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    @PostMapping
    public ResponseEntity<NoticeResponseDto> post(
            @Valid
            @RequestBody NoticeRequestDto requestDto
    ) {
        NoticeResponseDto post = noticeService.post(requestDto);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<NoticeResponseDto>> search(
    ) {
        List<NoticeResponseDto> search = noticeService.search();
        return new ResponseEntity<>(search,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NoticeResponseDto> update(
            @PathVariable Long id,
            @RequestBody UpdateRequestDto requsetDto
            ) {
        NoticeResponseDto update = noticeService.update(id, requsetDto.getTitle(), requsetDto.getContent());
        return new ResponseEntity<>(update,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id
    ) {
        noticeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
