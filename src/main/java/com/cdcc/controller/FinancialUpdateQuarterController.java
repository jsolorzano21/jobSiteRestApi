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

import com.cdcc.models.FinancialUpdateCurrentQuarter;
import com.cdcc.repository.FinancialUpdateQuarterRepository;

import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:3000", "https://carroll-daniel-finance.azurewebsites.net","https://finance.carrolldaniel.com"})
@RestController
public class FinancialUpdateQuarterController {
  
  @Autowired
  FinancialUpdateQuarterRepository financialUpdateQuarterRepository;
  
  @CrossOrigin(origins = {"http://localhost:3000", "https://carroll-daniel-finance.azurewebsites.net","https://finance.carrolldaniel.com"})
  @RequestMapping(method=RequestMethod.GET, value="/api/financialUpdateQuarterData")
  public Iterable<FinancialUpdateCurrentQuarter> products() {
	  System.out.println("GET Method entered");
      return financialUpdateQuarterRepository.findAll();
  }
  
  @CrossOrigin(origins = {"http://localhost:3000", "https://carroll-daniel-finance.azurewebsites.net","https://finance.carrolldaniel.com"})
  @RequestMapping(method=RequestMethod.POST, value="/api/financialUpdateQuarterData")
  public String save(@RequestBody FinancialUpdateCurrentQuarter financialResults) {
	  financialUpdateQuarterRepository.save(financialResults);

      return financialResults.getid();
  }
  
  @CrossOrigin(origins = {"http://localhost:3000", "https://carroll-daniel-finance.azurewebsites.net","https://finance.carrolldaniel.com"})
  @RequestMapping(method=RequestMethod.GET, value="/api/financialUpdateQuarterData/{id}")
  public Optional<FinancialUpdateCurrentQuarter> show(@PathVariable String id) {
      return financialUpdateQuarterRepository.findById(id);
  }

  @CrossOrigin(origins = {"http://localhost:3000", "https://carroll-daniel-finance.azurewebsites.net","https://finance.carrolldaniel.com"})
  @RequestMapping(method=RequestMethod.PUT, value="/api/financialUpdateQuarterData/{id}")
  public FinancialUpdateCurrentQuarter update(@PathVariable String id, @RequestBody FinancialUpdateCurrentQuarter financialResultsValue) {
	  Optional<FinancialUpdateCurrentQuarter> financialResultData = financialUpdateQuarterRepository.findById(id);
	  System.out.println(financialResultData.get().id);
	  financialResultsValue.setid(id);
      if(financialResultsValue.getCurrent_quarter() != null) {
    	  financialResultsValue.setCurrent_quarter(financialResultsValue.getCurrent_quarter());
      }else if(financialResultsValue.getCurrent_quarter() == null) {
    	  financialResultsValue.setCurrent_quarter(financialResultData.get().current_quarter);
      }
      
      if(financialResultsValue.getCurrent_year() != null) {
    	  financialResultsValue.setCurrent_year(financialResultsValue.getCurrent_year());
      }else if(financialResultsValue.getCurrent_year() == null) {
    	  financialResultsValue.setCurrent_year(financialResultData.get().current_year);
      }
      
      return financialUpdateQuarterRepository.save(financialResultsValue);
  }

  /*@RequestMapping(method=RequestMethod.DELETE, value="/api/financialUpdateQuarterData/{id}")
  public String delete(@PathVariable String id) {
      Optional<FinancialManagementAdjustment> product = financialManagementAdjustmentRepository.findById(id);
      financialManagementAdjustmentRepository.delete(product.get());

      return "record deleted";
  }*/
  
}
