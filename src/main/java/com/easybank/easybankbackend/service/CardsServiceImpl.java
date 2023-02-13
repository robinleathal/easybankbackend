package com.easybank.easybankbackend.service;

import com.easybank.easybankbackend.model.Cards;
import com.easybank.easybankbackend.repository.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardsServiceImpl implements CardsService {
    @Autowired
    CardsRepository cardsRepository;
    @Override
    public List<Cards> findByCustomerId(int id) {
        return cardsRepository.findByCustomerId(id);
    }
}
