package com.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.portfolio.entities.ContactMessage;

public interface ContactMessageRepo
        extends JpaRepository<ContactMessage, Long> {
}
