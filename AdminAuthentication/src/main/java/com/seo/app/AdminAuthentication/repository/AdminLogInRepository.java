package com.seo.app.AdminAuthentication.repository;

import com.seo.app.AdminAuthentication.domains.AdminLogInDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminLogInRepository extends JpaRepository<AdminLogInDomain,Integer> {

}
