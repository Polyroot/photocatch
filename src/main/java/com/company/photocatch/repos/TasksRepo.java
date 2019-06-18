package com.company.photocatch.repos;

import com.company.photocatch.domain.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TasksRepo extends CrudRepository<Task, Long> {


}
