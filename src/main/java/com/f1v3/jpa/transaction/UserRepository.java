package com.f1v3.jpa.transaction;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * {class name}.
 *
 * @author 정승조
 * @version 2024. 08. 23.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
