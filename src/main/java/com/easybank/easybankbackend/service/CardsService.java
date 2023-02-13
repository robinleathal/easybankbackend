package com.easybank.easybankbackend.service;

import com.easybank.easybankbackend.model.Cards;

import java.util.List;

public interface CardsService {
    List<Cards> findByCustomerId(int id);
}
