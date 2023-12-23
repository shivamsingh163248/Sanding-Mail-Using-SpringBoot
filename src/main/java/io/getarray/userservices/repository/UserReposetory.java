package io.getarray.userservices.repository;

import io.getarray.userservices.domain.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserReposetory extends JpaRepository<user, Long> {
    user findByEmailIgnoreCase(String email);
    Boolean existedByEmail(String email);

}
