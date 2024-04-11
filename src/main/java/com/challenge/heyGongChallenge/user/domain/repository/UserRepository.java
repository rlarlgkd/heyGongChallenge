package com.challenge.heyGongChallenge.user.domain.repository;

import com.challenge.heyGongChallenge.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {


}
