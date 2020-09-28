package com.cdcc.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cdcc.models.FinancialUpdateYearThreeReport;
import com.cdcc.repository.FinancialUpdateYearThreeReportRepository;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:3000", "https://carroll-daniel-finance.azurewebsites.net","https://finance.carrolldaniel.com"})
@RestController
public class FinancialUpdateYearThreeReportController {
  
  @Autowired
  FinancialUpdateYearThreeReportRepository financialUpdateYearThreeReportRepository;
  
  @CrossOrigin(origins = {"http://localhost:3000", "https://carroll-daniel-finance.azurewebsites.net","https://finance.carrolldaniel.com"})
  @RequestMapping(method=RequestMethod.GET, value="/api/financialUpdateYearThreeReport")
  public Iterable<FinancialUpdateYearThreeReport> products() {
	  System.out.println("GET Method entered");
      return financialUpdateYearThreeReportRepository.findAll();
  }
  
  @CrossOrigin(origins = {"http://localhost:3000", "https://carroll-daniel-finance.azurewebsites.net","https://finance.carrolldaniel.com"})
  @RequestMapping(method=RequestMethod.POST, value="/api/financialUpdateYearThreeReport")
  public String save(@RequestBody FinancialUpdateYearThreeReport financialResults) {
	  financialUpdateYearThreeReportRepository.save(financialResults);

      return financialResults.getid();
  }
  
  @CrossOrigin(origins = {"http://localhost:3000", "https://carroll-daniel-finance.azurewebsites.net","https://finance.carrolldaniel.com"})
  @RequestMapping(method=RequestMethod.GET, value="/api/financialUpdateYearThreeReport/{id}")
  public Optional<FinancialUpdateYearThreeReport> show(@PathVariable String id) {
      return financialUpdateYearThreeReportRepository.findById(id);
  }

  @CrossOrigin(origins = {"http://localhost:3000", "https://carroll-daniel-finance.azurewebsites.net","https://finance.carrolldaniel.com"})
  @RequestMapping(method=RequestMethod.PUT, value="/api/financialUpdateYearThreeReport/{id}")
  public FinancialUpdateYearThreeReport update(@PathVariable String id, @RequestBody FinancialUpdateYearThreeReport financialResultsValue) {
	  Optional<FinancialUpdateYearThreeReport> financialResultData = financialUpdateYearThreeReportRepository.findById(id);
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
      
      //Division 1
      
      if(financialResultsValue.getDiv_1_revenue_1() != null) {
    	  financialResultsValue.setDiv_1_revenue_1(financialResultsValue.getDiv_1_revenue_1());
      }else if(financialResultsValue.getDiv_1_revenue_1() == null) {
    	  financialResultsValue.setDiv_1_revenue_1(financialResultData.get().div_1_revenue_1);
      }
      
      if(financialResultsValue.getDiv_1_profit_1() != null) {
    	  financialResultsValue.setDiv_1_profit_1(financialResultsValue.getDiv_1_profit_1());
      }else if(financialResultsValue.getDiv_1_profit_1() == null) {
    	  financialResultsValue.setDiv_1_profit_1(financialResultData.get().div_1_profit_1);
      }
      
      if(financialResultsValue.getDiv_1_revenue_2() != null) {
    	  financialResultsValue.setDiv_1_revenue_2(financialResultsValue.getDiv_1_revenue_2());
      }else if(financialResultsValue.getDiv_1_revenue_2() == null) {
    	  financialResultsValue.setDiv_1_revenue_2(financialResultData.get().div_1_revenue_2);
      }
      
      if(financialResultsValue.getDiv_1_profit_2() != null) {
    	  financialResultsValue.setDiv_1_profit_2(financialResultsValue.getDiv_1_profit_2());
      }else if(financialResultsValue.getDiv_1_profit_2() == null) {
    	  financialResultsValue.setDiv_1_profit_2(financialResultData.get().div_1_profit_2);
      }
      
      if(financialResultsValue.getDiv_1_revenue_3() != null) {
    	  financialResultsValue.setDiv_1_revenue_3(financialResultsValue.getDiv_1_revenue_3());
      }else if(financialResultsValue.getDiv_1_revenue_3() == null) {
    	  financialResultsValue.setDiv_1_revenue_3(financialResultData.get().div_1_revenue_3);
      }
      
      if(financialResultsValue.getDiv_1_profit_3() != null) {
    	  financialResultsValue.setDiv_1_profit_3(financialResultsValue.getDiv_1_profit_3());
      }else if(financialResultsValue.getDiv_1_profit_3() == null) {
    	  financialResultsValue.setDiv_1_profit_3(financialResultData.get().div_1_profit_3);
      }
      
      //Division 2
      
      if(financialResultsValue.getDiv_2_revenue_1() != null) {
    	  financialResultsValue.setDiv_2_revenue_1(financialResultsValue.getDiv_2_revenue_1());
      }else if(financialResultsValue.getDiv_2_revenue_1() == null) {
    	  financialResultsValue.setDiv_2_revenue_1(financialResultData.get().div_2_revenue_1);
      }
      
      if(financialResultsValue.getDiv_2_profit_1() != null) {
    	  financialResultsValue.setDiv_2_profit_1(financialResultsValue.getDiv_2_profit_1());
      }else if(financialResultsValue.getDiv_2_profit_1() == null) {
    	  financialResultsValue.setDiv_2_profit_1(financialResultData.get().div_2_profit_1);
      }
      
      if(financialResultsValue.getDiv_2_revenue_2() != null) {
    	  financialResultsValue.setDiv_2_revenue_2(financialResultsValue.getDiv_2_revenue_2());
      }else if(financialResultsValue.getDiv_2_revenue_2() == null) {
    	  financialResultsValue.setDiv_2_revenue_2(financialResultData.get().div_2_revenue_2);
      }
      
      if(financialResultsValue.getDiv_2_profit_2() != null) {
    	  financialResultsValue.setDiv_2_profit_2(financialResultsValue.getDiv_2_profit_2());
      }else if(financialResultsValue.getDiv_2_profit_2() == null) {
    	  financialResultsValue.setDiv_2_profit_2(financialResultData.get().div_2_profit_2);
      }
      
      if(financialResultsValue.getDiv_2_revenue_3() != null) {
    	  financialResultsValue.setDiv_2_revenue_3(financialResultsValue.getDiv_2_revenue_3());
      }else if(financialResultsValue.getDiv_2_revenue_3() == null) {
    	  financialResultsValue.setDiv_2_revenue_3(financialResultData.get().div_2_revenue_3);
      }
      
      if(financialResultsValue.getDiv_2_profit_3() != null) {
    	  financialResultsValue.setDiv_2_profit_3(financialResultsValue.getDiv_2_profit_3());
      }else if(financialResultsValue.getDiv_2_profit_3() == null) {
    	  financialResultsValue.setDiv_2_profit_3(financialResultData.get().div_2_profit_3);
      }
      
      //Division 3
      
      if(financialResultsValue.getDiv_3_revenue_1() != null) {
    	  financialResultsValue.setDiv_3_revenue_1(financialResultsValue.getDiv_3_revenue_1());
      }else if(financialResultsValue.getDiv_3_revenue_1() == null) {
    	  financialResultsValue.setDiv_3_revenue_1(financialResultData.get().div_3_revenue_1);
      }
      
      if(financialResultsValue.getDiv_3_profit_1() != null) {
    	  financialResultsValue.setDiv_3_profit_1(financialResultsValue.getDiv_3_profit_1());
      }else if(financialResultsValue.getDiv_3_profit_1() == null) {
    	  financialResultsValue.setDiv_3_profit_1(financialResultData.get().div_3_profit_1);
      }
      
      if(financialResultsValue.getDiv_3_revenue_2() != null) {
    	  financialResultsValue.setDiv_3_revenue_2(financialResultsValue.getDiv_3_revenue_2());
      }else if(financialResultsValue.getDiv_3_revenue_2() == null) {
    	  financialResultsValue.setDiv_3_revenue_2(financialResultData.get().div_3_revenue_2);
      }
      
      if(financialResultsValue.getDiv_3_profit_2() != null) {
    	  financialResultsValue.setDiv_3_profit_2(financialResultsValue.getDiv_3_profit_2());
      }else if(financialResultsValue.getDiv_3_profit_2() == null) {
    	  financialResultsValue.setDiv_3_profit_2(financialResultData.get().div_3_profit_2);
      }
      
      if(financialResultsValue.getDiv_3_revenue_3() != null) {
    	  financialResultsValue.setDiv_3_revenue_3(financialResultsValue.getDiv_3_revenue_3());
      }else if(financialResultsValue.getDiv_3_revenue_3() == null) {
    	  financialResultsValue.setDiv_3_revenue_3(financialResultData.get().div_3_revenue_3);
      }
      
      if(financialResultsValue.getDiv_3_profit_3() != null) {
    	  financialResultsValue.setDiv_3_profit_3(financialResultsValue.getDiv_3_profit_3());
      }else if(financialResultsValue.getDiv_3_profit_3() == null) {
    	  financialResultsValue.setDiv_3_profit_3(financialResultData.get().div_3_profit_3);
      }
      
      //Division 4
      
      if(financialResultsValue.getDiv_4_revenue_1() != null) {
    	  financialResultsValue.setDiv_4_revenue_1(financialResultsValue.getDiv_4_revenue_1());
      }else if(financialResultsValue.getDiv_4_revenue_1() == null) {
    	  financialResultsValue.setDiv_4_revenue_1(financialResultData.get().div_4_revenue_1);
      }
      
      if(financialResultsValue.getDiv_4_profit_1() != null) {
    	  financialResultsValue.setDiv_4_profit_1(financialResultsValue.getDiv_4_profit_1());
      }else if(financialResultsValue.getDiv_4_profit_1() == null) {
    	  financialResultsValue.setDiv_4_profit_1(financialResultData.get().div_4_profit_1);
      }
      
      if(financialResultsValue.getDiv_4_revenue_2() != null) {
    	  financialResultsValue.setDiv_4_revenue_2(financialResultsValue.getDiv_4_revenue_2());
      }else if(financialResultsValue.getDiv_4_revenue_2() == null) {
    	  financialResultsValue.setDiv_4_revenue_2(financialResultData.get().div_4_revenue_2);
      }
      
      if(financialResultsValue.getDiv_4_profit_2() != null) {
    	  financialResultsValue.setDiv_4_profit_2(financialResultsValue.getDiv_4_profit_2());
      }else if(financialResultsValue.getDiv_4_profit_2() == null) {
    	  financialResultsValue.setDiv_4_profit_2(financialResultData.get().div_4_profit_2);
      }
      
      if(financialResultsValue.getDiv_4_revenue_3() != null) {
    	  financialResultsValue.setDiv_4_revenue_3(financialResultsValue.getDiv_4_revenue_3());
      }else if(financialResultsValue.getDiv_4_revenue_3() == null) {
    	  financialResultsValue.setDiv_4_revenue_3(financialResultData.get().div_4_revenue_3);
      }
      
      if(financialResultsValue.getDiv_4_profit_3() != null) {
    	  financialResultsValue.setDiv_4_profit_3(financialResultsValue.getDiv_4_profit_3());
      }else if(financialResultsValue.getDiv_4_profit_3() == null) {
    	  financialResultsValue.setDiv_4_profit_3(financialResultData.get().div_4_profit_3);
      }
      
      //Division 5
      
      if(financialResultsValue.getDiv_5_revenue_1() != null) {
    	  financialResultsValue.setDiv_5_revenue_1(financialResultsValue.getDiv_5_revenue_1());
      }else if(financialResultsValue.getDiv_5_revenue_1() == null) {
    	  financialResultsValue.setDiv_5_revenue_1(financialResultData.get().div_5_revenue_1);
      }
      
      if(financialResultsValue.getDiv_5_profit_1() != null) {
    	  financialResultsValue.setDiv_5_profit_1(financialResultsValue.getDiv_5_profit_1());
      }else if(financialResultsValue.getDiv_5_profit_1() == null) {
    	  financialResultsValue.setDiv_5_profit_1(financialResultData.get().div_5_profit_1);
      }
      
      if(financialResultsValue.getDiv_5_revenue_2() != null) {
    	  financialResultsValue.setDiv_5_revenue_2(financialResultsValue.getDiv_5_revenue_2());
      }else if(financialResultsValue.getDiv_5_revenue_2() == null) {
    	  financialResultsValue.setDiv_5_revenue_2(financialResultData.get().div_5_revenue_2);
      }
      
      if(financialResultsValue.getDiv_5_profit_2() != null) {
    	  financialResultsValue.setDiv_5_profit_2(financialResultsValue.getDiv_5_profit_2());
      }else if(financialResultsValue.getDiv_5_profit_2() == null) {
    	  financialResultsValue.setDiv_5_profit_2(financialResultData.get().div_5_profit_2);
      }
      
      if(financialResultsValue.getDiv_5_revenue_3() != null) {
    	  financialResultsValue.setDiv_5_revenue_3(financialResultsValue.getDiv_5_revenue_3());
      }else if(financialResultsValue.getDiv_5_revenue_3() == null) {
    	  financialResultsValue.setDiv_5_revenue_3(financialResultData.get().div_5_revenue_3);
      }
      
      if(financialResultsValue.getDiv_5_profit_3() != null) {
    	  financialResultsValue.setDiv_5_profit_3(financialResultsValue.getDiv_5_profit_3());
      }else if(financialResultsValue.getDiv_5_profit_3() == null) {
    	  financialResultsValue.setDiv_5_profit_3(financialResultData.get().div_5_profit_3);
      }
      
      //Division 6
      
      if(financialResultsValue.getDiv_6_revenue_1() != null) {
    	  financialResultsValue.setDiv_6_revenue_1(financialResultsValue.getDiv_6_revenue_1());
      }else if(financialResultsValue.getDiv_6_revenue_1() == null) {
    	  financialResultsValue.setDiv_6_revenue_1(financialResultData.get().div_6_revenue_1);
      }
      
      if(financialResultsValue.getDiv_6_profit_1() != null) {
    	  financialResultsValue.setDiv_6_profit_1(financialResultsValue.getDiv_6_profit_1());
      }else if(financialResultsValue.getDiv_6_profit_1() == null) {
    	  financialResultsValue.setDiv_6_profit_1(financialResultData.get().div_6_profit_1);
      }
      
      if(financialResultsValue.getDiv_6_revenue_2() != null) {
    	  financialResultsValue.setDiv_6_revenue_2(financialResultsValue.getDiv_6_revenue_2());
      }else if(financialResultsValue.getDiv_6_revenue_2() == null) {
    	  financialResultsValue.setDiv_6_revenue_2(financialResultData.get().div_6_revenue_2);
      }
      
      if(financialResultsValue.getDiv_6_profit_2() != null) {
    	  financialResultsValue.setDiv_6_profit_2(financialResultsValue.getDiv_6_profit_2());
      }else if(financialResultsValue.getDiv_6_profit_2() == null) {
    	  financialResultsValue.setDiv_6_profit_2(financialResultData.get().div_6_profit_2);
      }
      
      if(financialResultsValue.getDiv_6_revenue_3() != null) {
    	  financialResultsValue.setDiv_6_revenue_3(financialResultsValue.getDiv_6_revenue_3());
      }else if(financialResultsValue.getDiv_6_revenue_3() == null) {
    	  financialResultsValue.setDiv_6_revenue_3(financialResultData.get().div_6_revenue_3);
      }
      
      if(financialResultsValue.getDiv_6_profit_3() != null) {
    	  financialResultsValue.setDiv_6_profit_3(financialResultsValue.getDiv_6_profit_3());
      }else if(financialResultsValue.getDiv_6_profit_3() == null) {
    	  financialResultsValue.setDiv_6_profit_3(financialResultData.get().div_6_profit_3);
      }
      
      //Division 7
      
      if(financialResultsValue.getDiv_7_revenue_1() != null) {
    	  financialResultsValue.setDiv_7_revenue_1(financialResultsValue.getDiv_7_revenue_1());
      }else if(financialResultsValue.getDiv_7_revenue_1() == null) {
    	  financialResultsValue.setDiv_7_revenue_1(financialResultData.get().div_7_revenue_1);
      }
      
      if(financialResultsValue.getDiv_7_profit_1() != null) {
    	  financialResultsValue.setDiv_7_profit_1(financialResultsValue.getDiv_7_profit_1());
      }else if(financialResultsValue.getDiv_7_profit_1() == null) {
    	  financialResultsValue.setDiv_7_profit_1(financialResultData.get().div_7_profit_1);
      }
      
      if(financialResultsValue.getDiv_7_revenue_2() != null) {
    	  financialResultsValue.setDiv_7_revenue_2(financialResultsValue.getDiv_7_revenue_2());
      }else if(financialResultsValue.getDiv_7_revenue_2() == null) {
    	  financialResultsValue.setDiv_7_revenue_2(financialResultData.get().div_7_revenue_2);
      }
      
      if(financialResultsValue.getDiv_7_profit_2() != null) {
    	  financialResultsValue.setDiv_7_profit_2(financialResultsValue.getDiv_7_profit_2());
      }else if(financialResultsValue.getDiv_7_profit_2() == null) {
    	  financialResultsValue.setDiv_7_profit_2(financialResultData.get().div_7_profit_2);
      }
      
      if(financialResultsValue.getDiv_7_revenue_3() != null) {
    	  financialResultsValue.setDiv_7_revenue_3(financialResultsValue.getDiv_7_revenue_3());
      }else if(financialResultsValue.getDiv_7_revenue_3() == null) {
    	  financialResultsValue.setDiv_7_revenue_3(financialResultData.get().div_7_revenue_3);
      }
      
      if(financialResultsValue.getDiv_7_profit_3() != null) {
    	  financialResultsValue.setDiv_7_profit_3(financialResultsValue.getDiv_7_profit_3());
      }else if(financialResultsValue.getDiv_7_profit_3() == null) {
    	  financialResultsValue.setDiv_7_profit_3(financialResultData.get().div_7_profit_3);
      }
      
      //Division 11
      
      if(financialResultsValue.getDiv_11_revenue_1() != null) {
    	  financialResultsValue.setDiv_11_revenue_1(financialResultsValue.getDiv_11_revenue_1());
      }else if(financialResultsValue.getDiv_11_revenue_1() == null) {
    	  financialResultsValue.setDiv_11_revenue_1(financialResultData.get().div_11_revenue_1);
      }
      
      if(financialResultsValue.getDiv_11_profit_1() != null) {
    	  financialResultsValue.setDiv_11_profit_1(financialResultsValue.getDiv_11_profit_1());
      }else if(financialResultsValue.getDiv_11_profit_1() == null) {
    	  financialResultsValue.setDiv_11_profit_1(financialResultData.get().div_11_profit_1);
      }
      
      if(financialResultsValue.getDiv_11_revenue_2() != null) {
    	  financialResultsValue.setDiv_11_revenue_2(financialResultsValue.getDiv_11_revenue_2());
      }else if(financialResultsValue.getDiv_11_revenue_2() == null) {
    	  financialResultsValue.setDiv_11_revenue_2(financialResultData.get().div_11_revenue_2);
      }
      
      if(financialResultsValue.getDiv_11_profit_2() != null) {
    	  financialResultsValue.setDiv_11_profit_2(financialResultsValue.getDiv_11_profit_2());
      }else if(financialResultsValue.getDiv_11_profit_2() == null) {
    	  financialResultsValue.setDiv_11_profit_2(financialResultData.get().div_11_profit_2);
      }
      
      if(financialResultsValue.getDiv_11_revenue_3() != null) {
    	  financialResultsValue.setDiv_11_revenue_3(financialResultsValue.getDiv_11_revenue_3());
      }else if(financialResultsValue.getDiv_11_revenue_3() == null) {
    	  financialResultsValue.setDiv_11_revenue_3(financialResultData.get().div_11_revenue_3);
      }
      
      if(financialResultsValue.getDiv_11_profit_3() != null) {
    	  financialResultsValue.setDiv_11_profit_3(financialResultsValue.getDiv_11_profit_3());
      }else if(financialResultsValue.getDiv_11_profit_3() == null) {
    	  financialResultsValue.setDiv_11_profit_3(financialResultData.get().div_11_profit_3);
      }
      
      return financialUpdateYearThreeReportRepository.save(financialResultsValue);
  }

  /*@RequestMapping(method=RequestMethod.DELETE, value="/api/financialUpdateQuarterData/{id}")
  public String delete(@PathVariable String id) {
      Optional<FinancialManagementAdjustment> product = financialManagementAdjustmentRepository.findById(id);
      financialManagementAdjustmentRepository.delete(product.get());

      return "record deleted";
  }*/
  
}
