package com.freewiki.wikiapp.repository;

import com.freewiki.wikiapp.model.MyUser;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface MyUserRepository extends JpaRepository<MyUser, Long> {
    Optional<MyUser> findUserByEmail(String email);
    Optional<MyUser> findUserByUsername(String username);
    Optional<MyUser> findUserById(Long id);
    Optional<MyUser> findUserByUsernameAndPassword(String username, String password);
    @Modifying
    @Query(value = "insert into users (created_at, email, password, username) values (:createdAt, :email, :password, :username)", nativeQuery = true)
    @Transactional
    void insertUser(@Param("createdAt") Date createdAt, @Param("email") String email, @Param("password") String password, @Param("username") String username);
}
