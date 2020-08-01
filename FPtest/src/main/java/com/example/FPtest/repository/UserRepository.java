package com.example.FPtest.repository;


//import com.example.FPtest.model.CreditCard;
import com.example.FPtest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
     Optional <User> findByUsername(String username);
     //Optional <User> findByUser(User user);

}