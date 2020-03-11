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

import com.cdcc.models.FinancialDataActualBudget;
import com.cdcc.repository.FinancialActualBudgetRepository;

import java.util.Optional;

@RestController
public class FinancialActualBudgetController {
  
  @Autowired
  FinancialActualBudgetRepository financialActualBudgetRepository;
  
  @CrossOrigin(origins = "http://localhost:3000")
  @RequestMapping(method=RequestMethod.GET, value="/api/financialActualBudgetData")
  public Iterable<FinancialDataActualBudget> products() {
	  System.out.println("GET Method entered");
      return financialActualBudgetRepository.findAll();
  }
  
  @RequestMapping(method=RequestMethod.POST, value="/api/financialActualBudgetData")
  public String save(@RequestBody FinancialDataActualBudget financialResults) {
	  financialActualBudgetRepository.save(financialResults);

      return financialResults.get_id();
  }
  
  @RequestMapping(method=RequestMethod.GET, value="/api/financialActualBudgetData/{id}")
  @CrossOrigin(origins = "http://localhost:3000")
  public Optional<FinancialDataActualBudget> show(@PathVariable String id) {
      return financialActualBudgetRepository.findById(id);
  }
  
  @RequestMapping(method=RequestMethod.PUT, value="/api/financialActualBudgetData/{id}")
  public FinancialDataActualBudget update(@PathVariable String id, @RequestBody FinancialDataActualBudget financialResultsValue) {
      Optional<FinancialDataActualBudget> financialResultData = financialActualBudgetRepository.findById(id);
      if(financialResultsValue.getDepartment() != null)
    	  financialResultData.get().setDepartment(financialResultsValue.getDepartment());
      if(financialResultsValue.getAccount() != null)
    	  financialResultData.get().setAccount(financialResultsValue.getAccount());
      if(financialResultsValue.getName() != null)
    	  financialResultData.get().setName(financialResultsValue.getName());
      if(financialResultsValue.getStatus() != null)
    	  financialResultData.get().setStatus(financialResultsValue.getStatus());
      if(financialResultsValue.getYear() != null)
    	  financialResultData.get().setYear(financialResultsValue.getYear());
      if(financialResultsValue.getQuarter() != null)
    	  financialResultData.get().setQuarter(financialResultsValue.getQuarter());
      if(financialResultsValue.getPeriod_1() != null)
    	  financialResultData.get().setPeriod_1(financialResultsValue.getPeriod_1());
      if(financialResultsValue.getPeriod_2() != null)
    	  financialResultData.get().setPeriod_2(financialResultsValue.getPeriod_2());
      if(financialResultsValue.getPeriod_3() != null)
    	  financialResultData.get().setPeriod_3(financialResultsValue.getPeriod_3());
      if(financialResultsValue.getPeriod_4() != null)
    	  financialResultData.get().setPeriod_4(financialResultsValue.getPeriod_4());
      if(financialResultsValue.getPeriod_5() != null)
    	  financialResultData.get().setPeriod_5(financialResultsValue.getPeriod_5());
      if(financialResultsValue.getPeriod_6() != null)
    	  financialResultData.get().setPeriod_6(financialResultsValue.getPeriod_6());
      if(financialResultsValue.getPeriod_7() != null)
    	  financialResultData.get().setPeriod_7(financialResultsValue.getPeriod_7());
      if(financialResultsValue.getPeriod_8() != null)
    	  financialResultData.get().setPeriod_8(financialResultsValue.getPeriod_8());
      if(financialResultsValue.getPeriod_9() != null)
    	  financialResultData.get().setPeriod_9(financialResultsValue.getPeriod_9());
      if(financialResultsValue.getPeriod_10() != null)
    	  financialResultData.get().setPeriod_10(financialResultsValue.getPeriod_10());
      if(financialResultsValue.getPeriod_11() != null)
    	  financialResultData.get().setPeriod_11(financialResultsValue.getPeriod_11());
      if(financialResultsValue.getPeriod_12() != null)
    	  financialResultData.get().setPeriod_12(financialResultsValue.getPeriod_12());
      return financialResultData.get();
  }

  @RequestMapping(method=RequestMethod.DELETE, value="/api/financialActualBudgetData/{id}")
  public String delete(@PathVariable String id) {
      Optional<FinancialDataActualBudget> product = financialActualBudgetRepository.findById(id);
      financialActualBudgetRepository.delete(product.get());

      return "record deleted";
  }
  
}
