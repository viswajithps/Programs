package com.iiht.many2many.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iiht.many2many.model.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {

}
