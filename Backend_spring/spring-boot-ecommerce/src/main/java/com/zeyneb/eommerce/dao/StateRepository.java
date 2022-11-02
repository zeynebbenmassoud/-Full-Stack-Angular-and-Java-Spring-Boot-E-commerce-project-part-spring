package com.zeyneb.eommerce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.zeyneb.eommerce.entity.State;

@RepositoryRestResource
public interface StateRepository extends JpaRepository<State, Integer> {

	//localhost:8080/api/states/search/foundByCountryCode?code=US  
	List<State> findByCountryCode(@Param("code") String code);
}
