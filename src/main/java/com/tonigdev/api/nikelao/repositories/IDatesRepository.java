package com.tonigdev.api.nikelao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tonigdev.api.nikelao.model.Dates;

public interface IDatesRepository extends JpaRepository<Dates, Long>{


	@Query("SELECT d FROM Dates d where d.date LIKE %:date% and (d.stateDate.id = 1 or d.stateDate.id = 2)")
	public List<Dates> findByDateReservedFinish(@Param("date") String date);
	
	@Query("SELECT d FROM Dates d where d.date LIKE %:date%")
	public List<Dates> findByDate(@Param("date") String date);

}
