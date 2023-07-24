package com.savingfootprints.adapter.h2.user;

import com.savingfootprints.adapter.h2.user.data.UserData;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepository extends ReactiveCrudRepository<UserData, String> {
}
