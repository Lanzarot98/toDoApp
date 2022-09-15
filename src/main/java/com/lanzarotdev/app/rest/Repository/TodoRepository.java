package com.lanzarotdev.app.rest.Repository;

import com.lanzarotdev.app.rest.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Task, Long> {

}
