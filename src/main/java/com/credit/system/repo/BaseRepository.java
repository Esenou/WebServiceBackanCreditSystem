package com.credit.system.repo;


import com.credit.system.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository<E extends BaseEntity> extends JpaRepository<E, Long > {
}
