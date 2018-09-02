package com.bakery.dao;

import com.bakery.model.SocialMediaAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialMediaAccountDAO extends JpaRepository<SocialMediaAccount, Long> {
}
