package com.f1v3.jpa.transaction;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SecondService {

    private final ItemRepository itemRepository;

    @Transactional
    public Boolean readSample(Long id) {
        Optional<ItemEntity> entity = itemRepository.findById(id);
        return entity.isPresent();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Boolean unreadSample(Long id) {
        Optional<ItemEntity> entity = itemRepository.findById(id);
        return entity.isPresent();
    }

}
