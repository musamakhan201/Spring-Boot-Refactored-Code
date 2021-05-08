package com.seo.app.AdminAuthentication.repository;

import com.seo.app.AdminAuthentication.domains.TipsDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipsRepository extends JpaRepository<TipsDomain, Integer> {
}
