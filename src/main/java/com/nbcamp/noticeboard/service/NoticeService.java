package com.nbcamp.noticeboard.service;

import com.nbcamp.noticeboard.dto.NoticeRequestDto;
import com.nbcamp.noticeboard.dto.NoticeResponseDto;
import com.nbcamp.noticeboard.entity.Notice;
import com.nbcamp.noticeboard.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeRepository noticeRepository;

    public NoticeResponseDto post(NoticeRequestDto requestDto) {
        Notice notice = new Notice(requestDto.getTitle(), requestDto.getContent(), requestDto.getAuthor());
        Notice save = noticeRepository.save(notice);
        return new NoticeResponseDto(save.getId(), save.getTitle(), save.getContent(), save.getAuthor());
    }

    public List<NoticeResponseDto> search() {
        return noticeRepository.findAll()
                .stream()
                .map(NoticeResponseDto::toDto)
                .toList();


    }

    @Transactional
    public NoticeResponseDto update(Long id, String title, String content) {
        Notice notice = noticeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notice not found with id: " + id));
        notice.update(title, content);
        return new NoticeResponseDto(notice.getId(), notice.getTitle(), notice.getContent(), notice.getAuthor());
    }


    public void delete(Long id) {
        Notice notice = noticeRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Notice not found with id: " + id));
        noticeRepository.delete(notice);
    }
}
