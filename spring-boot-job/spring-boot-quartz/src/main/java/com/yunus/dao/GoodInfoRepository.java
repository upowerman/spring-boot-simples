package com.yunus.dao;

import com.yunus.entity.GoodInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodInfoRepository
        extends JpaRepository<GoodInfoEntity, Long> {
}
