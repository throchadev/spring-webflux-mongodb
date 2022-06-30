package br.com.throchadev.springwebfluxmongodb.service;

import br.com.throchadev.springwebfluxmongodb.dto.UserDto;
import br.com.throchadev.springwebfluxmongodb.repository.UserRepository;
import br.com.throchadev.springwebfluxmongodb.utils.AppUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public Mono<UserDto> createUser(Mono<UserDto> userDto){
    return userDto.map(AppUtils::dtoToEntity)
        .flatMap(userRepository::save)
        .map(AppUtils::entityToDto);
  }

  public Flux<UserDto> getAllUsers(){
    return userRepository.findAll().map(AppUtils::entityToDto);
  }

  public Mono<UserDto> findById(String userId){
    return userRepository.findById(userId).map(AppUtils::entityToDto);
  }

  public Mono<UserDto> updateUser(String id, Mono<UserDto> userDto){
    return userRepository.findById(id)
        .flatMap(p -> userDto.map(AppUtils::dtoToEntity)
            .doOnNext(e -> e.setId(id)))
        .flatMap(userRepository::save)
        .map(AppUtils::entityToDto);

  }

  public Mono<Void> deleteUser(String id){
    return userRepository.deleteById(id);
  }

  public Flux<UserDto> findByName(String name) {
    return userRepository.findByName(name).map(AppUtils::entityToDto);
  }
}
