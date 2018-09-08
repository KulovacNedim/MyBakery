package com.bakery.repository;

import com.bakery.model.SocialMediaAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialMediaAccountRepository extends JpaRepository<SocialMediaAccount, Long> {
}
