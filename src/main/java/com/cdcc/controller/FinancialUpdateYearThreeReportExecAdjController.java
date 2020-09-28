package com.cdcc.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cdcc.models.FinancialUpdateYearThreeReportExecAdj;
import com.cdcc.repository.FinancialUpdateYearThreeReportExecAdjRepository;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:3000", "https://carroll-daniel-finance.azurewebsites.net","https://finance.carrolldaniel.com"})
@RestController
public class FinancialUpdateYearThreeReportExecAdjController {
  
  @Autowired
  FinancialUpdateYearThreeReportExecAdjRepository financialUpdateYearThreeReportExecAdjRepository;
  
  @CrossOrigin(origins = {"http://localhost:3000", "https://carroll-daniel-finance.azurewebsites.net","https://finance.carrolldaniel.com"})
  @RequestMapping(method=RequestMethod.GET, value="/api/financialUpdateYearThreeReportExecAdj")
  public Iterable<FinancialUpdateYearThreeReportExecAdj> products() {
	  System.out.println("GET Method entered");
      return financialUpdateYearThreeReportExecAdjRepository.findAll();
  }
  
  @CrossOrigin(origins = {"http://localhost:3000", "https://carroll-daniel-finance.azurewebsites.net","https://finance.carrolldaniel.com"})
  @RequestMapping(method=RequestMethod.POST, value="/api/financialUpdateYearThreeReportExecAdj")
  public String save(@RequestBody FinancialUpdateYearThreeReportExecAdj financialResults) {
	  financialUpdateYearThreeReportExecAdjRepository.save(financialResults);

      return financialResults.getid();
  }
  
  @CrossOrigin(origins = {"http://localhost:3000", "https://carroll-daniel-finance.azurewebsites.net","https://finance.carrolldaniel.com"})
  @RequestMapping(method=RequestMethod.GET, value="/api/financialUpdateYearThreeReportExecAdj/{id}")
  public Optional<FinancialUpdateYearThreeReportExecAdj> show(@PathVariable String id) {
      return financialUpdateYearThreeReportExecAdjRepository.findById(id);
  }

  @CrossOrigin(origins = {"http://localhost:3000", "https://carroll-daniel-finance.azurewebsites.net","https://finance.carrolldaniel.com"})
  @RequestMapping(method=RequestMethod.PUT, value="/api/financialUpdateYearThreeReportExecAdj/{id}")
  public FinancialUpdateYearThreeReportExecAdj update(@PathVariable String id, @RequestBody FinancialUpdateYearThreeReportExecAdj financialResultsValue) {
	  Optional<FinancialUpdateYearThreeReportExecAdj> financialResultData = financialUpdateYearThreeReportExecAdjRepository.findById(id);
	  System.out.println(financialResultData.get().id);
	  financialResultsValue.setid(id);
      if(financialResultsValue.getQuarter() != null) {
    	  financialResultsValue.setQuarter(financialResultsValue.getQuarter());
      }else if(financialResultsValue.getQuarter() == null) {
    	  financialResultsValue.setQuarter(financialResultData.get().quarter);
      }
      
      if(financialResultsValue.getYear() != null) {
    	  financialResultsValue.setYear(financialResultsValue.getYear());
      }else if(financialResultsValue.getYear() == null) {
    	  financialResultsValue.setYear(financialResultData.get().year);
      }
      
      //Division
      
      if(financialResultsValue.getDivision() != null) {
    	  financialResultsValue.setDivision(financialResultsValue.getDivision());
      }else if(financialResultsValue.getDivision() == null) {
    	  financialResultsValue.setDivision(financialResultData.get().division);
      }
      
      //Year 1 Revenue
      
      if(financialResultsValue.getYear_1_revenue() != null) {
    	  financialResultsValue.setYear_1_revenue(financialResultsValue.getYear_1_revenue());
      }else if(financialResultsValue.getYear_1_revenue() == null) {
    	  financialResultsValue.setYear_1_revenue(financialResultData.get().year_1_revenue);
      }
      
      //Year 1 Profit
      
      if(financialResultsValue.getYear_1_profit() != null) {
    	  financialResultsValue.setYear_1_profit(financialResultsValue.getYear_1_profit());
      }else if(financialResultsValue.getYear_1_profit() == null) {
    	  financialResultsValue.setYear_1_profit(financialResultData.get().year_1_profit);
      }
      
      //Year 2 Revenue
      
      if(financialResultsValue.getYear_2_revenue() != null) {
    	  financialResultsValue.setYear_2_revenue(financialResultsValue.getYear_2_revenue());
      }else if(financialResultsValue.getYear_2_revenue() == null) {
    	  financialResultsValue.setYear_2_revenue(financialResultData.get().year_2_revenue);
      }
      
      //Year 2 Profit
      
      if(financialResultsValue.getYear_2_profit() != null) {
    	  financialResultsValue.setYear_2_profit(financialResultsValue.getYear_2_profit());
      }else if(financialResultsValue.getYear_2_profit() == null) {
    	  financialResultsValue.setYear_2_profit(financialResultData.get().year_2_profit);
      }
      
      //Year 3 Revenue
      
      if(financialResultsValue.getYear_3_revenue() != null) {
    	  financialResultsValue.setYear_3_revenue(financialResultsValue.getYear_3_revenue());
      }else if(financialResultsValue.getYear_3_revenue() == null) {
    	  financialResultsValue.setYear_3_revenue(financialResultData.get().year_3_revenue);
      }
      
      //Year 3 Profit
      
      if(financialResultsValue.getYear_3_profit() != null) {
    	  financialResultsValue.setYear_3_profit(financialResultsValue.getYear_3_profit());
      }else if(financialResultsValue.getYear_3_profit() == null) {
    	  financialResultsValue.setYear_3_profit(financialResultData.get().year_3_profit);
      }
      
     
      
      return financialUpdateYearThreeReportExecAdjRepository.save(financialResultsValue);
  }

  /*@RequestMapping(method=RequestMethod.DELETE, value="/api/financialUpdateQuarterData/{id}")
  public String delete(@PathVariable String id) {
      Optional<FinancialManagementAdjustment> product = financialManagementAdjustmentRepository.findById(id);
      financialManagementAdjustmentRepository.delete(product.get());

      return "record deleted";
  }*/
  
}
