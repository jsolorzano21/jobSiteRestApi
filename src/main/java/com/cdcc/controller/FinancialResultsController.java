package com.cdcc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.cdcc.models.FinancialDataResults;
import com.cdcc.repository.FinancialResultsRepository;

import java.util.Optional;

@RestController
public class FinancialResultsController {
  
  @Autowired
  FinancialResultsRepository financialResultsRepository;
  
  @CrossOrigin(origins = "http://localhost:3000")
  @RequestMapping(method=RequestMethod.GET, value="/api/financialResultsData")
  public Iterable<FinancialDataResults> product() {
	  System.out.println("GET Method entered");
      return financialResultsRepository.findAll();
  }
  
  @RequestMapping(method=RequestMethod.POST, value="/api/financialResultsData")
  public String save(@RequestBody FinancialDataResults financialResults) {
	  financialResultsRepository.save(financialResults);

      return financialResults.get_id();
  }
  
  @RequestMapping(method=RequestMethod.GET, value="/api/financialResultsData/{id}")
  @CrossOrigin(origins = "http://localhost:3000")
  public Optional<FinancialDataResults> show(@PathVariable String id) {
      return financialResultsRepository.findById(id);
  }
  
  @RequestMapping(method=RequestMethod.PUT, value="/api/financialResultsData/{id}")
  public FinancialDataResults update(@PathVariable String id, @RequestBody FinancialDataResults financialResultsValue) {
      Optional<FinancialDataResults> financialResultData = financialResultsRepository.findById(id);
      if(financialResultsValue.getdivision() != null)
    	  financialResultData.get().setdivision(financialResultsValue.getdivision());
      if(financialResultsValue.getdept_job() != null)
    	  financialResultData.get().setdept_job(financialResultsValue.getdept_job());
      if(financialResultsValue.getyear() != null)
    	  financialResultData.get().setyear(financialResultsValue.getyear());
      if(financialResultsValue.getquarter() != null)
    	  financialResultData.get().setquarter(financialResultsValue.getquarter());
      if(financialResultsValue.getJob_name() != null)
    	  financialResultData.get().setJob_name(financialResultsValue.getJob_name());
      if(financialResultsValue.getStart_date() != null)
    	  financialResultData.get().setStart_date(financialResultsValue.getStart_date());
      if(financialResultsValue.getEnd_date() != null)
    	  financialResultData.get().setEnd_date(financialResultsValue.getEnd_date());
      if(financialResultsValue.getContract_amount() != null)
    	  financialResultData.get().setContract_amount(financialResultsValue.getContract_amount());
      if(financialResultsValue.getProject_cost() != null)
    	  financialResultData.get().setProject_cost(financialResultsValue.getProject_cost());
      if(financialResultsValue.getEarned_revenue() != null)
    	  financialResultData.get().setEarned_revenue(financialResultsValue.getEarned_revenue());
      if(financialResultsValue.getEarned_revenue_YTD() != null)
    	  financialResultData.get().setEarned_revenue_YTD(financialResultsValue.getEarned_revenue_YTD());
      if(financialResultsValue.getBonded() != null)
    	  financialResultData.get().setBonded(financialResultsValue.getBonded());
      if(financialResultsValue.getgross_margin_percent() != null)
    	  financialResultData.get().setgross_margin_percent(financialResultsValue.getgross_margin_percent());
      if(financialResultsValue.getBacklog() != null)
    	  financialResultData.get().setBacklog(financialResultsValue.getBacklog());
      if(financialResultsValue.getStatus() != null)
    	  financialResultData.get().setStatus(financialResultsValue.getStatus());
      if(financialResultsValue.getHit_ratio() != null)
    	  financialResultData.get().setHit_ratio(financialResultsValue.getHit_ratio());
      financialResultsRepository.save(financialResultData.get());
      return financialResultData.get();
  }

  @RequestMapping(method=RequestMethod.DELETE, value="/api/financialResultsData/{id}")
  public String delete(@PathVariable String id) {
      Optional<FinancialDataResults> product = financialResultsRepository.findById(id);
      financialResultsRepository.delete(product.get());

      return "record deleted";
  }
  
}
