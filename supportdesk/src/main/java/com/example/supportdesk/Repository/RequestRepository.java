package com.example.supportdesk.Repository;

import com.example.supportdesk.Model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
    // No extra methods needed for now
}
