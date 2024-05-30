package com.f1v3.transactional.propagation.service;

import com.f1v3.transactional.propagation.domain.Child;
import com.f1v3.transactional.propagation.repository.ChildRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ChildService {

    private final ChildRepository childRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save() {
        Child child = Child.builder()
                .name("new Child")
                .build();

        childRepository.save(child);

        throw new IllegalStateException("REQUIRES_NEW 테스트");
    }

}
