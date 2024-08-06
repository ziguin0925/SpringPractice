package com.example.demo.JPA.Repository;

import com.example.demo.JPA.Entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {


}
