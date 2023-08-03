package com.savingfootprints.adapter.h2.user;

import com.savingfootprints.adapter.h2.user.data.UserData;
import com.savingfootprints.model.User;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<UserData, String> {

    @Query("UPDATE users SET " +
            "name = CASE WHEN :#{#p.name} IS NOT NULL THEN :#{#p.name} ELSE name END, " +
            "last_name = CASE WHEN :#{#p.lastName} IS NOT NULL THEN :#{#p.lastName} ELSE last_name END, " +
            "document_type = CASE WHEN :#{#p.documentType} IS NOT NULL THEN :#{#p.documentType} ELSE document_type END, " +
            "document = CASE WHEN :#{#p.document} IS NOT NULL THEN :#{#p.document} ELSE document END, " +
            "phone = CASE WHEN :#{#p.phone} IS NOT NULL THEN :#{#p.phone} ELSE phone END, " +
            "email = CASE WHEN :#{#p.email} IS NOT NULL THEN :#{#p.email} ELSE email END " +
            "WHERE id = :#{#p.id}")
    Mono<Void> updateUser(@Param("p") User user);
}
