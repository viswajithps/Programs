package com.iiht.store.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iiht.store.entity.Milk;

@Repository
public interface MilkRepository extends JpaRepository<Milk,Long> {

}
