package com.f1v3.jpa.relation;

import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    @Query("SELECT b, c " +
            "FROM Board b LEFT JOIN Comment c " +
            "ON b.id = c.boardId")
    List<Tuple> getByIdWithComment();
}
