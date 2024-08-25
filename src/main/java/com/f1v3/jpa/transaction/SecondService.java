package com.f1v3.jpa.transaction;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SecondService {

    private final ItemRepository itemRepository;

    @Transactional
    public boolean readSample(Long id) {
        return itemRepository.existsById(id);
    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED, propagation = Propagation.REQUIRES_NEW)
    public boolean unreadSample(Long id) {
        return itemRepository.existsById(id);
    }

}
