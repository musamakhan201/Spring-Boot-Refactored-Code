package com.seo.app.AdminAuthentication.repository;

import com.seo.app.AdminAuthentication.domains.AdminRegistrationDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRegistrationRepository extends JpaRepository<AdminRegistrationDomain, Integer> {
}
