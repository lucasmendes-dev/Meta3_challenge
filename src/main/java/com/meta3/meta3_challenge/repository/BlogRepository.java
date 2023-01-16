package com.meta3.meta3_challenge.repository;

import com.meta3.meta3_challenge.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Post, Long> {
}
