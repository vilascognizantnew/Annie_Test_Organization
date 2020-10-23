package com.cts.controller;

import java.util.Date;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.model.Organization;
import com.cts.service.OrganizationService;


@RestController
public class OrganizationController {
	@Autowired    
	private OrganizationService organizationService;     
	
	
	@GetMapping(value = "/organizationList")
	public ResponseEntity<Object> organizationList()
	{
		
		return new ResponseEntity<>(organizationService.allStock(),HttpStatus.OK);
	}
	@GetMapping(value = "/getOrganizationById/id/{id}/name/{name}")
	public ResponseEntity<Object> personList(@PathVariable("id") Integer id)
	{
		
			Organization organization = organizationService.searchOrganizationById(id);
			if(organization!=null) {
				
				return new ResponseEntity<>(organization,HttpStatus.OK);	
			}
			else
			return new ResponseEntity<>("Resord Not Found",HttpStatus.OK);
				
	}
	
	@GetMapping(value="/searchOrganizationByName/{name}")
	public ResponseEntity<?> searchOrganizationById(@PathVariable("name") String name)
	{
		Organization s = OrganizationService.searchOrganizationByName(name);
		if(s==null){
			return new ResponseEntity<String>("not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Organization>(s,HttpStatus.OK);
	}
	@GetMapping(value="/searchOrganizationByPrice/{startTurnover}/{endTurnover}")
	public ResponseEntity<?> searchOrganizationByPrice(@PathVariable("startTurnover") Double startPrice, @PathVariable("endTurnover") Double endTurnover )
	{
		List <Organization> s = organizationService.searchOrganizationByTurnover(startTurnover,endTurnover);
		if(s.size()==0){
			return new ResponseEntity<String>("not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Organization>>(s,HttpStatus.OK);
	}
	
	@GetMapping(value="/searchOrganizationByDate/{startDate}/{endDate}")
	public ResponseEntity<?> searchOrganizationByDate(@PathVariable("startDate") Date startDate, @PathVariable("endDate") Date endDate )
	{
		List s = organizationService.searchOrganizationByDate(startDate,endDate);
		if(s.size()==0){
			return new ResponseEntity<String>("not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List>(s,HttpStatus.OK);
	}
	
	@GetMapping(value="/topFiveOrganization")
	public ResponseEntity<?> topFiveOrganization()
	{
		return new ResponseEntity List<Organization>(organizationService.topFiveOrganization(),HttpStatus.OK);
	}

}
