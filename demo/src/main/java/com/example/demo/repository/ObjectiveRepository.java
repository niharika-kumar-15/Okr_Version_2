package com.example.demo.repository;
import com.example.demo.model.Objective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Repository
public interface ObjectiveRepository extends JpaRepository<Objective, Long> {
    List<Objective> findByUserId(Long userId);

    @Query(value = " SELECT o.*, u.username FROM objectives o join users u on  o.objective_id = u. objective_id where u.user_id= :userId" , nativeQuery = true)
        //SELECT o.*, u.username FROM objectives o join users u on  o.objective_id = u. objective_id where  u.user_id=2;
    List<Objective> findObjectivesByUser(@RequestParam("userId") Long userId);
    // You can add other custom queries here if needed


    @Override
    Optional<Objective> findById(@PathVariable("objectiveId") Long objectiveId);
}