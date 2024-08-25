package com.f1v3.jpa.transaction;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final SecondService secondService;

    public void save() {
        ItemEntity item = ItemEntity.builder()
                .id(1L)
                .name("test")
                .build();

        itemRepository.save(item);
    }

    @Transactional
    public void saveWithTransaction() {
        ItemEntity item = ItemEntity.builder()
                .id(1L)
                .name("test")
                .build();

        itemRepository.save(item);
    }

    public void saveWithException() {
        ItemEntity item = ItemEntity.builder()
                .id(1L)
                .name("test")
                .build();

        itemRepository.save(item);
        throw new RuntimeException("saveWithException - error");
    }


    @Transactional
    public void saveWithTransactionException() {
        ItemEntity item = ItemEntity.builder()
                .id(1L)
                .name("test")
                .build();

        itemRepository.save(item);
        throw new RuntimeException("saveWithTransactionException - error");
    }

    @Transactional
    public void sample() {
        ItemEntity item = ItemEntity.builder()
                .id(1L)
                .name("test")
                .build();

        ItemEntity savedItem = itemRepository.save(item);

        Boolean ret = secondService.readSample(savedItem.getId());
        Boolean ret2 = secondService.unreadSample(savedItem.getId());

        log.info("readSample = {}", ret);
        log.info("unreadSample = {}", ret2);
    }

}
