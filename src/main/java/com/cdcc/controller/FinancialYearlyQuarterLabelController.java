package com.cdcc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cdcc.models.FinancialYearlyQuarterLabel;
import com.cdcc.repository.FinancialYearlyQuarterLabelRepository;

import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:3000", "https://carroll-daniel-finance.azurewebsites.net","https://finance.carrolldaniel.com"})
@RestController
public class FinancialYearlyQuarterLabelController {
  
  @Autowired
  FinancialYearlyQuarterLabelRepository financialYearlyQuarterLabelRepository;
  
  @CrossOrigin(origins = {"http://localhost:3000", "https://carroll-daniel-finance.azurewebsites.net","https://finance.carrolldaniel.com"})
  @RequestMapping(method=RequestMethod.GET, value="/api/financialYearlyQuarterLabel")
  public Iterable<FinancialYearlyQuarterLabel> products() {
	  System.out.println("GET Method entered");
      return financialYearlyQuarterLabelRepository.findAll();
  }
  
  @CrossOrigin(origins = {"http://localhost:3000", "https://carroll-daniel-finance.azurewebsites.net","https://finance.carrolldaniel.com"})
  @RequestMapping(method=RequestMethod.POST, value="/api/financialYearlyQuarterLabel")
  public String save(@RequestBody FinancialYearlyQuarterLabel financialResults) {
	  financialYearlyQuarterLabelRepository.save(financialResults);

      return financialResults.getid();
  }
  
  @CrossOrigin(origins = {"http://localhost:3000", "https://carroll-daniel-finance.azurewebsites.net","https://finance.carrolldaniel.com"})
  @RequestMapping(method=RequestMethod.GET, value="/api/financialYearlyQuarterLabel/{id}")
  public Optional<FinancialYearlyQuarterLabel> show(@PathVariable String id) {
      return financialYearlyQuarterLabelRepository.findById(id);
  }

  /*@RequestMapping(method=RequestMethod.PUT, value="/api/financialUserInformation/{id}")
  public FinancialUserInformation update(@PathVariable String id, @RequestBody FinancialUserInformation financialResultsValue) {
	  Optional<FinancialUserInformation> financialResultData = financialUserInformationRepository.findById(id);
	  System.out.println(financialResultData.get().id);
	  financialResultsValue.setid(id);
      if(financialResultsValue.getuserdivision() != null) {
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
  }*/

  @CrossOrigin(origins = {"http://localhost:3000", "https://carroll-daniel-finance.azurewebsites.net","https://finance.carrolldaniel.com"})
  @RequestMapping(method=RequestMethod.DELETE, value="/api/financialYearlyQuarterLabel/{id}")
  public String delete(@PathVariable String id) {
      Optional<FinancialYearlyQuarterLabel> product = financialYearlyQuarterLabelRepository.findById(id);
      financialYearlyQuarterLabelRepository.delete(product.get());

      return "record deleted";
  }
  
}
