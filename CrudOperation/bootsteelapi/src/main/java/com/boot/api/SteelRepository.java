package com.boot.api;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

public interface SteelRepository extends JpaRepository<Steel, Integer>
{
public Steel findById(int id);
	
}
