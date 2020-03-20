package com.microservice.architecture.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.microservice.architecture.entity.Microservices;
import com.microservice.architecture.repository.MicroservicesPageRepository;
import com.microservice.architecture.repository.MicroservicesRepository;

@Service
public class MicroserviceService implements GA4GHServiceInterface {

	
	private MicroservicesRepository GA4GHRepository;
	
	@Autowired
	private MicroservicesPageRepository pg;

	@Autowired   
	public MicroserviceService(MicroservicesRepository GA4GHRepository)
	{
		this.GA4GHRepository=GA4GHRepository;
	}
	
	
	public List<Microservices> findAll() {
		return GA4GHRepository.findAll();
	}

	public void save(Microservices OBJ) {
		
		GA4GHRepository.save(OBJ);
	}

	public void deleteById(int theId) {
		
		GA4GHRepository.deleteById(theId);
	}

	public Microservices findById(int theId) {
		
		return GA4GHRepository.findById(theId);
	}


	public List<Microservices> findBySequence_Name(String seq) {
		
		return GA4GHRepository.findBySequencename(seq);
	}


	public List<Microservices> findByGenBank_Accn(String seq) {
		
		return GA4GHRepository.findByGenbankaccn(seq);
	}


	public List<Microservices> findByRefseq_Accn(String seq) {
		
		return GA4GHRepository.findByRefseqaccn(seq);
	}
	
	public List<Microservices> findBySequencelength(String seq)
	{
		return GA4GHRepository.findBySequencelength(seq);
	}
	
	public List<Microservices> findPage(Integer pageNo, Integer pageSize, String sortBy)
    {
        PageRequest paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy) );
 
        Page<Microservices> pagedResult = pg.findAll(paging);
         
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return null;
        }
    }
	

}