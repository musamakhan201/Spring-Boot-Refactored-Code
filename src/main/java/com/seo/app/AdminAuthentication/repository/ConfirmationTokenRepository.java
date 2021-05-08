package com.seo.app.AdminAuthentication.repository;

import com.seo.app.AdminAuthentication.domains.ConfirmationTokenDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationTokenDomain, String> {
    ConfirmationTokenDomain findByConfirmationToken(String token);
}
