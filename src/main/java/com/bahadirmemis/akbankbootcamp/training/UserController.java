package com.bahadirmemis.akbankbootcamp.training;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bahadirmemis
 */
//@RestController
//@RequestMapping("/api/v1/users")
//@Validated
public class UserController {

  @GetMapping
  public ResponseEntity<String> getUsers(){
    String str = "get all users";

    return ResponseEntity.ok(str);
  }

  @GetMapping("/{id}")
  public String getUserById(@PathVariable @Positive Long id){
    return "get user with id: " + id;
  }

  @PostMapping
  public String saveUser(@RequestBody @Valid UserSaveRequestDTO userSaveRequestDTO){
    return userSaveRequestDTO + " saved!";
  }

  @PutMapping("/{id}")
  public String updateUser(@PathVariable Long id, @RequestBody UserSaveRequestDTO userSaveRequestDTO){
    return userSaveRequestDTO + " updated! with id: " + id;
  }

  /**
   * http://localhost:8080/api/v1/users/
   * http://localhost:8080/api/v1/users/18 -> /18 kısmı path variable
   * http://localhost:8080/api/v1/users?name=bahadir&surname=memis
   *
   * update user set name=2y3, surname=sdjhgkshd
   * where name=:name and surname=:surname
   * @param name
   * @param surname
   * @param userSaveRequestDTO
   * @return
   */
  @PutMapping
  public String updateUserWithNameAndSurname(
      @RequestParam String name,
      @RequestParam String surname, @Valid @RequestBody UserSaveRequestDTO userSaveRequestDTO){
    return userSaveRequestDTO + " updated! with name&surname: " + name + " " + surname;
  }

  @DeleteMapping("/{id}")
  public String deleteUser(@PathVariable Long id){
    return "user deleted: " + id;
  }
}
