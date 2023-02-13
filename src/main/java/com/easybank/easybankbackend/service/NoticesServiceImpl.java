package com.easybank.easybankbackend.service;

import com.easybank.easybankbackend.model.Notice;
import com.easybank.easybankbackend.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticesServiceImpl implements NoticesService {
    @Autowired
    private NoticeRepository noticeRepository;
    @Override
    public List<Notice> findAllActiveNotices() {
        return noticeRepository.findAllActiveNotices();
    }
}
