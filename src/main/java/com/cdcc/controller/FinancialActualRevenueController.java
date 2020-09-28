package com.cdcc.controller;

import org.bson.types.ObjectId;
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

import com.cdcc.models.FinancialActualRevenue;
import com.cdcc.repository.FinancialActualRevenueRepository;

import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:3000", "https://carroll-daniel-finance.azurewebsites.net","https://finance.carrolldaniel.com"})
@RestController
public class FinancialActualRevenueController {
  
  @Autowired
  FinancialActualRevenueRepository financialActualRevenueRepository;
  
  @CrossOrigin(origins = {"http://localhost:3000", "https://carroll-daniel-finance.azurewebsites.net","https://finance.carrolldaniel.com"})
  @RequestMapping(method=RequestMethod.GET, value="/api/financialActualRevenue")
  public Iterable<FinancialActualRevenue> products() {
	  System.out.println("GET Method entered");
      return financialActualRevenueRepository.findAll();
  }
  
  @CrossOrigin(origins = {"http://localhost:3000", "https://carroll-daniel-finance.azurewebsites.net","https://finance.carrolldaniel.com"})
  @RequestMapping(method=RequestMethod.POST, value="/api/financialActualRevenue")
  public String save(@RequestBody FinancialActualRevenue financialResults) {
	  financialActualRevenueRepository.save(financialResults);

      return financialResults.getid();
  }
  
  @CrossOrigin(origins = {"http://localhost:3000", "https://carroll-daniel-finance.azurewebsites.net","https://finance.carrolldaniel.com"})
  @RequestMapping(method=RequestMethod.GET, value="/api/financialActualRevenue/{id}")
  public Optional<FinancialActualRevenue> show(@PathVariable String id) {
      return financialActualRevenueRepository.findById(id);
  }

  @CrossOrigin(origins = {"http://localhost:3000", "https://carroll-daniel-finance.azurewebsites.net","https://finance.carrolldaniel.com"})
  @RequestMapping(method=RequestMethod.PUT, value="/api/financialActualRevenue/{id}")
  public FinancialActualRevenue update(@PathVariable String id, @RequestBody FinancialActualRevenue financialResultsValue) {
	  Optional<FinancialActualRevenue> financialResultData = financialActualRevenueRepository.findById(id);
	  System.out.println(financialResultData.get().id);
	  financialResultsValue.setid(id);
      if(financialResultsValue.getYear() != null) {
    	  financialResultsValue.setYear(financialResultsValue.getYear());
      }else if(financialResultsValue.getYear() == null) {
    	  financialResultsValue.setYear(financialResultData.get().year);
      }
      
      if(financialResultsValue.getMonth() != null) {
    	  financialResultsValue.setMonth(financialResultsValue.getMonth());
      }else if(financialResultsValue.getMonth() == null) {
    	  financialResultsValue.setMonth(financialResultData.get().month);
      }
      
      if(financialResultsValue.getDivision() != null) {
    	  financialResultsValue.setDivision(financialResultsValue.getDivision());
      }else if(financialResultsValue.getDivision() == null) {
    	  financialResultsValue.setDivision(financialResultData.get().division);
      }
      
      if(financialResultsValue.getActual() != null) {
    	  financialResultsValue.setActual(financialResultsValue.getActual());
      }else if(financialResultsValue.getActual() == null) {
    	  financialResultsValue.setActual(financialResultData.get().actual);
      }
      
      return financialActualRevenueRepository.save(financialResultsValue);
  }

  /*@RequestMapping(method=RequestMethod.DELETE, value="/api/financialUpdateQuarterData/{id}")
  public String delete(@PathVariable String id) {
      Optional<FinancialManagementAdjustment> product = financialManagementAdjustmentRepository.findById(id);
      financialManagementAdjustmentRepository.delete(product.get());

      return "record deleted";
  }*/
  
}
