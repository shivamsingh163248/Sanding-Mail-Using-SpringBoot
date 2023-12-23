package io.getarray.userservices.repository;


import io.getarray.userservices.domain.Confermation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfirmationRepositary extends JpaRepository<Confermation , Long> {
    Confermation findByTocken(String token);

}
