package xyz.team1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xyz.team1.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    
}
