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

import com.cdcc.models.FinancialManagementAdjustment;
import com.cdcc.repository.FinancialManagementAdjustmentRepository;

import java.util.Optional;

@RestController
public class FinancialManagementAdjustmentController {
  
  @Autowired
  FinancialManagementAdjustmentRepository financialManagementAdjustmentRepository;
  
  @CrossOrigin(origins = "http://localhost:3000")
  @RequestMapping(method=RequestMethod.GET, value="/api/financialManagementAdjustmentData")
  public Iterable<FinancialManagementAdjustment> products() {
	  System.out.println("GET Method entered");
      return financialManagementAdjustmentRepository.findAll();
  }
  
  @RequestMapping(method=RequestMethod.POST, value="/api/financialManagementAdjustmentData")
  public String save(@RequestBody FinancialManagementAdjustment financialResults) {
	  financialManagementAdjustmentRepository.save(financialResults);

      return financialResults.getid();
  }
  
  @RequestMapping(method=RequestMethod.GET, value="/api/financialManagementAdjustmentData/{id}")
  @CrossOrigin(origins = "http://localhost:3000")
  public Optional<FinancialManagementAdjustment> show(@PathVariable String id) {
      return financialManagementAdjustmentRepository.findById(id);
  }

  @RequestMapping(method=RequestMethod.PUT, value="/api/financialManagementAdjustmentData/{id}")
  public FinancialManagementAdjustment update(@PathVariable String id, @RequestBody FinancialManagementAdjustment financialResultsValue) {
	  Optional<FinancialManagementAdjustment> financialResultData = financialManagementAdjustmentRepository.findById(id);
	  System.out.println(financialResultData.get().id);
	  financialResultsValue.setid(id);
	  financialResultsValue.setDivision(financialResultData.get().division);
	  financialResultsValue.setQuarter(financialResultData.get().quarter);
	  financialResultsValue.setYear(financialResultData.get().year);
      if(financialResultsValue.getMa_revenue() != null) {
    	  financialResultsValue.setMa_revenue(financialResultsValue.getMa_revenue());
      }else if(financialResultsValue.getMa_revenue() == null) {
    	  financialResultsValue.setMa_revenue(financialResultData.get().ma_revenue);
      }  
      if(financialResultsValue.getMa_profit() != null) {
    	  financialResultsValue.setMa_profit(financialResultsValue.getMa_profit());
      }else if(financialResultsValue.getMa_profit() == null) {
    	  financialResultsValue.setMa_profit(financialResultData.get().ma_profit);
      }
      
      return financialManagementAdjustmentRepository.save(financialResultsValue);
  }

  @RequestMapping(method=RequestMethod.DELETE, value="/api/financialManagementAdjustment/{id}")
  public String delete(@PathVariable String id) {
      Optional<FinancialManagementAdjustment> product = financialManagementAdjustmentRepository.findById(id);
      financialManagementAdjustmentRepository.delete(product.get());

      return "record deleted";
  }
  
}
