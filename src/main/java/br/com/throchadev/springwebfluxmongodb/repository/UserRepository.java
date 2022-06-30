package br.com.throchadev.springwebfluxmongodb.repository;

import br.com.throchadev.springwebfluxmongodb.entity.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {

  Flux<User> findByName(String name);
}
