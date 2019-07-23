package com.company.photocatch.repos;

import com.company.photocatch.domain.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TasksRepo extends CrudRepository<Task, Long> {

    @Query(value = "select * from task t join usr u on t.user_id = u.id where t.id = (select MAX(ta.id) from task ta)", nativeQuery = true)
    Task getTaskMaxId(Long id);

}
