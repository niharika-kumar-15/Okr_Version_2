package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
    User findByUserId(Long managerId);
    List<User> findByManagerId(Long managerId);

    @Query("SELECT u FROM User u WHERE u.managerId = :managerId")
    List<User> findUsersByManagerId(Long managerId);

    // Corrected query using JOIN to find users by objectiveId
    @Query(" Select u From User u join Objective o on  o.objectiveId = :objectiveId")
    List<User> findUsersByObjectiveId(@RequestParam("objectiveId") Long objectiveId);////
//    @Query("SELECT u FROM User u JOIN u.objectives o WHERE o.objectiveId = :objectiveId")
//    List<User> findUsersByObjectiveId(Long objectiveId);



//    SELECT u.*
//    FROM users u
//    JOIN objectives o ON o.objective_id = u.objective_id
//    WHERE o.objective_id = 1;
}
