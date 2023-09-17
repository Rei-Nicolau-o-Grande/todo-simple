package com.projeto.todosimple.repositories;

import com.projeto.todosimple.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByUser_Id(Long id);

//    @Query("SELECT t FROM Task t WHERE t.user.id = :id")
//    List<Task> BuscaDonoTask(@Param("id") Long id);

//    @Query(nativeQuery = true, value = "SELECT * FROM task t  WHERE t.user_id = :id")
//    List<Task> QuerySQL(@Param("id") Long id);
}
