package com.easybank.easybankbackend.service;

import com.easybank.easybankbackend.model.Notice;

import java.util.List;

public interface NoticesService {
    List<Notice> findAllActiveNotices();
}
