package com.nbcamp.noticeboard.repository;

import com.nbcamp.noticeboard.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
}
