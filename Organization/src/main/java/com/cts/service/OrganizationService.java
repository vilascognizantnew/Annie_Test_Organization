package com.cts.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.dao.OrganizationRepository;
import com.cts.model.Organization;


@Service
public class OrganizationService {
	@Autowired    
	private OrganizationRepository organizationRepository;
	public List<Organization> allOrganization(){
		return (List<Organization>) organizationRepository.findAll();
	}
	
	public List<Organization> topFiveOrganization(){
		return (List<Organization>) organizationRepository.findTopFiveOrganization(0);
	}
	
	public Organization searchOrganizationById(int id){
		Optional<Organization> s = organizationRepository.findByID(id);
		if(s.isPresent()){
			return s.get();
		}
		return null;
	}
	
	public static Organization searchOrganizationByName(String name){
		Optional <Organization> s =organizationRepository.findByOrganizationName(name);
		if(s.isPresent()){
			return s.get();
		}
		return null;
	}
	
	public List<Organization> searchOrganizationByTurnover(Double startTurnover, Double endTurnover){
		return (List<Organization>) organizationRepository.findByTurnoverBetween(startTurnover,endTurnover);
	}

	public List<Organization> searchOrganizationByDate(Date startDate, Date endDate){
		return (List<Organization>) organizationRepository.findByDateBetween(startDate,endDate);
	}
}
