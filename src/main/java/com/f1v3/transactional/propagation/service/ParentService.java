package com.f1v3.transactional.propagation.service;

import com.f1v3.transactional.propagation.domain.Parent;
import com.f1v3.transactional.propagation.repository.ParentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ParentService {

    private final ParentRepository parentRepository;
    private final ChildService childService;

    @Transactional
    public void savePropagation() {
        Parent parent = Parent.builder()
                .name("new Parent")
                .build();

        // 여기서 저장한 parent 정보는 DB에 저장되어야 한다.
        parentRepository.save(parent);

        // 아래에서 저장한 child 정보는 DB에 저장되지 않아야 한다.
        childService.save();
    }

    @Transactional(readOnly = true)
    public void saveReadOnly() {
        Parent parent = Parent.builder()
                .name("read only Parent")
                .build();

        // readOnly=true 옵션을 주고 저장한다면 저장이 안될까?
        parentRepository.save(parent);
    }
}
