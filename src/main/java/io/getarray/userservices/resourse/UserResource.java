package io.getarray.userservices.resourse;

import io.getarray.userservices.domain.HttpResponse;
import io.getarray.userservices.domain.user;
import io.getarray.userservices.service.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserResource {
 private  final UserServices userServices ;

 @PostMapping
    public ResponseEntity<HttpResponse> creatUser(@RequestBody user User){

     user newUser = userServices.saveUser(User) ;
     return ResponseEntity.created(URI.create("")).body(
             HttpResponse.builder()
                     .timeStemp(LocalDateTime.now().toString())
                     .data(Map.of("User", newUser))
                     .message("User Created")
                     .status(HttpStatus.CREATED)
                     .statusCode(HttpStatus.CREATED.value())
                     .build()
     );


 }

 @GetMapping
 public ResponseEntity<HttpResponse> confirmUserAccount(@RequestParam("token") String token){

  boolean isSuccess =  userServices.varifyToken(token) ;
  return ResponseEntity.ok().body(
          HttpResponse.builder()
                  .timeStemp(LocalDateTime.now().toString())
                  .data(Map.of("Success", isSuccess))
                  .message("Account Varyfind")
                  .status(HttpStatus.OK)
                  .statusCode(HttpStatus.OK.value())
                  .build()
  );


 }


}
