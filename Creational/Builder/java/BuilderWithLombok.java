package com.example.tutpoint.learn;

import lombok.Builder;
import lombok.Data;

/**
 * @Builder will generate all the boiler plate required to generate a builder for the class
 */
@Builder
@Data
public class BuilderWithLombok {
  String name;
  int age;
  String address;
}

class BuilderWithLombokInstance {
  static void main(String[] args) {
    BuilderWithLombok object = BuilderWithLombok.builder()
            .name("Name")
            .age(11)
            .address("1, ABC")
            .build();
  }
}
