package br.com.throchadev.springwebfluxmongodb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

  private String id;
  private String name;
  private int age;
  private double salary;
  private String department;
}
