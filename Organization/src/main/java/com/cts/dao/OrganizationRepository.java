package com.cts.dao;
import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.model.Organization;

@Repository
public interface OrganizationRepository extends CrudRepository<Organization, String> {
 
	List<Organization> findTopFiveOrganization(float turnover);

	List<Organization> findByID(int id);

	List<Organization> findByOrganizationName(String name);

	Iterable<Organization> findAll();
	public List<Organization> findByTurnoverBetween(Double startTurnover, Double endTurnover);
	
	List<Organization> findByDateBetween(Date startDate, Date endDate);
}
