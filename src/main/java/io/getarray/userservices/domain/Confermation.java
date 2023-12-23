package io.getarray.userservices.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Setter
@Getter
@Entity
@Table(name = "Confirmation")

public class Confermation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String token ;


    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private LocalDateTime createdDate ;

    @OneToOne(targetEntity = user.class , fetch = FetchType.EAGER)
    @JoinColumn(nullable = false , name = "user_id")
    private  user User ;

    // now creating the constocter
    public Confermation(user User){
        this.User = User ;
        this.createdDate = LocalDateTime.now();
        this.token = UUID.randomUUID().toString();

    }

}
