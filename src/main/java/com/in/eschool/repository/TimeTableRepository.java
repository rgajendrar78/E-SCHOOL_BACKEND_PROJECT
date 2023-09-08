package com.in.eschool.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.in.eschool.model.TimeTable;
@Repository
public interface TimeTableRepository extends CrudRepository<TimeTable, Integer> {

}
