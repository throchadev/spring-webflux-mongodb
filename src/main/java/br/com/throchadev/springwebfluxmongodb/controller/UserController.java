package br.com.throchadev.springwebfluxmongodb.controller;

import br.com.throchadev.springwebfluxmongodb.dto.UserDto;
import br.com.throchadev.springwebfluxmongodb.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<UserDto> create(@RequestBody Mono<UserDto> userDto){
    return userService.createUser(userDto);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public Flux<UserDto> getAllUsers(){
    return userService.getAllUsers();
  }

  @GetMapping("/{userId}")
  @ResponseStatus(HttpStatus.OK)
  public Mono<UserDto> getUserById(@PathVariable String userId){
    return userService.findById(userId);
  }

  @PutMapping("/update/{userId}")
  @ResponseStatus(HttpStatus.OK)
  public Mono<UserDto> updateUserById(@PathVariable String userId, @RequestBody Mono<UserDto> userDto){
    return userService.updateUser(userId, userDto);
  }

  @DeleteMapping("/delete/{userId}")
  @ResponseStatus(HttpStatus.OK)
  public Mono<Void> deleteUserById(@PathVariable String userId){
    return userService.deleteUser(userId);
  }

  @RequestMapping(value = "/name/{name}")
  @ResponseStatus(HttpStatus.OK)
  public Flux<UserDto> findByName(@PathVariable String name) {
    return userService.findByName(name);
  }
}
