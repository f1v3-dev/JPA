package com.f1v3.jpa;

import com.f1v3.jpa.propagation.repository.ParentRepository;
import com.f1v3.jpa.propagation.service.ParentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ReadOnlyTest {

    @Autowired
    ParentService parentService;

    @Autowired
    ParentRepository parentRepository;

    @Test
    @DisplayName("readonly=true 옵션을 주고 save를 호출한다면?")
    void readOnlyTest() {
        // given
        parentService.saveReadOnly();

        // expected
        assertEquals(0L, parentRepository.count());
    }
}
