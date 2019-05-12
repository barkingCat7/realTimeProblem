package com.app;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TimeTableRepository extends CrudRepository<TimeTable, Integer> {

	List<TimeTable> findAllByOrderByDateTimeDesc();

	List<TimeTable> findAllByDateTimeBetween(Timestamp t1, Timestamp t2);

	List<TimeTable> findAllByDateTimeBetweenOrderByDateTimeAsc(Timestamp t1, Timestamp t2);
}
