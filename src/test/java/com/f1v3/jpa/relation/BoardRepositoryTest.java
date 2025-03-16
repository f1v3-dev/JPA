package com.f1v3.jpa.relation;

import jakarta.persistence.Tuple;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;


@DataJpaTest
class BoardRepositoryTest {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    CommentRepository commentRepository;

    @Test
    void test() {
        Board board = Board.builder()
                .title("제목123")
                .content("내용12313")
                .build();

        Board savedBoard = boardRepository.save(board);

        Comment comment = Comment.builder()
                .boardId(savedBoard.getId())
                .comment("쵝오")
                .build();

        commentRepository.save(comment);

        boardRepository.getByIdWithComment()
                .forEach(
                        tuple -> {
                            Board b = tuple.get(0, Board.class);
                            Comment c = tuple.get(1, Comment.class);

                            System.out.println("board = " + b);
                            System.out.println("comment = " + c);
                        }
                );

    }


}