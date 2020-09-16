package com.hive6.um.webapp.core.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    
    public final static String FIND_BY_USER_ID_QUERY = "SELECT u FROM UserEntity u WHERE u.id = :id";
    /**
     * Find user by id.
     */
    @Query(FIND_BY_USER_ID_QUERY)
    public Optional<UserEntity> findByUserId(@Param("id") Long id);
}