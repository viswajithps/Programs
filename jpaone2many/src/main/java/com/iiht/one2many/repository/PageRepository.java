package com.iiht.one2many.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iiht.one2many.entity.Page;

@Repository
public interface PageRepository extends JpaRepository<Page, Long>  {

}
