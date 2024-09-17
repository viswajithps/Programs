package com.iiht.many2many.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iiht.many2many.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
