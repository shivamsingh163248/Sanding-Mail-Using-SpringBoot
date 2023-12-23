package io.getarray.userservices.resourse;

import io.getarray.userservices.domain.user;
import io.getarray.userservices.service.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserResource {
 private  final UserServices userServices ;

 @PostMapping
    public ResponseEntity<String> creatUser(@RequestBody user User){



 }

}
