package com.f1v3.jpa;

import com.f1v3.jpa.test.repository.ChildRepository;
import com.f1v3.jpa.test.repository.ParentRepository;
import com.f1v3.jpa.test.service.ChildService;
import com.f1v3.jpa.test.service.ParentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PropagationTest {

    @Autowired
    ParentService parentService;

    @Autowired
    ChildService childService;

    @Autowired
    ParentRepository parentRepository;

    @Autowired
    ChildRepository childRepository;

    @Test
    @DisplayName("전파 옵션 REQUIRES_NEW 테스트")
    void requiresNewTest() {

        // given
        parentService.savePropagation();

        /**
         * parent의 정보는 DB에 저장되어야 하고,
         * child의 정보는 DB에 저장되지 않아야 한다.
         */

        // expected
        assertEquals(1L, parentRepository.count());
        assertEquals(0L, childRepository.count());

    }

}
