package br.com.throchadev.springwebfluxmongodb.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "users")
public class User {

  @Id
  private String id;
  private String name;
  private int age;
  private double salary;
  private String department;
}
