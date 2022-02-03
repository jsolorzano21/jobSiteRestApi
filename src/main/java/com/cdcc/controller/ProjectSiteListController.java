package com.cdcc.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cdcc.models.ProjectSiteList;
import com.cdcc.repository.ProjectSiteListRepository;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:3000", "https://projectadmin.carrolldaniel.com", "https://project.carrolldaniel.com"})
@RestController
public class ProjectSiteListController {
  
  @Autowired
  ProjectSiteListRepository projectSiteListRepository;
  
  @CrossOrigin(origins = {"http://localhost:3000", "https://projectadmin.carrolldaniel.com", "https://project.carrolldaniel.com"})
  @RequestMapping(method=RequestMethod.GET, value="/api/projectSiteListInformation")
  public Iterable<ProjectSiteList> products() {
	  System.out.println("GET Method entered");
      return projectSiteListRepository.findAll();
  }
  
  @CrossOrigin(origins = {"http://localhost:3000", "https://projectadmin.carrolldaniel.com", "https://project.carrolldaniel.com"})
  @RequestMapping(method=RequestMethod.POST, value="/api/projectSiteListInformation")
  public List<ProjectSiteList> save(@RequestBody ProjectSiteList projectSiteListResults) {
	  System.out.println(projectSiteListResults);
	  projectSiteListRepository.save(projectSiteListResults);

      return projectSiteListRepository.findAll();
  }
  
  @CrossOrigin(origins = {"http://localhost:3000", "https://projectadmin.carrolldaniel.com", "https://project.carrolldaniel.com"})
  @RequestMapping(method=RequestMethod.GET, value="/api/projectSiteListInformation/{id}")
  public Optional<ProjectSiteList> show(@PathVariable String id) {
      return projectSiteListRepository.findById(id);
  }

  @CrossOrigin(origins = {"http://localhost:3000", "https://projectadmin.carrolldaniel.com", "https://project.carrolldaniel.com"})
  @RequestMapping(method=RequestMethod.PUT, value="/api/projectSiteListViewPage/{id}")
  public ProjectSiteList update(@PathVariable String id, @RequestBody ProjectSiteList projectSiteListResults) {
	  Optional<ProjectSiteList> financialResultData = projectSiteListRepository.findById(id);
	  System.out.println(financialResultData.get().id);
	  projectSiteListResults.setid(id);
	  projectSiteListResults.setProduction(financialResultData.get().getProduction());
	  //siteImage
	  if(projectSiteListResults.getDevelopment().get(0).siteImage != null) {
		  projectSiteListResults.development.get(0).setSiteImage(projectSiteListResults.getDevelopment().get(0).getSiteImage());
	  }else if(projectSiteListResults.getDevelopment().get(0).siteImage == null) {
		  projectSiteListResults.development.get(0).setSiteImage(financialResultData.get().getDevelopment().get(0).getSiteImage());
	  }
	  
	  //siteName
	  if(projectSiteListResults.getDevelopment().get(0).siteName != null) {
		  projectSiteListResults.development.get(0).setSiteName(projectSiteListResults.getDevelopment().get(0).getSiteName());
	  }else if(projectSiteListResults.getDevelopment().get(0).siteName == null) {
		  projectSiteListResults.development.get(0).setSiteName(financialResultData.get().getDevelopment().get(0).getSiteName());
	  }
	  
	//siteNeedPublish
	  if(projectSiteListResults.getDevelopment().get(0).siteNeedsPublish != null) {
		  projectSiteListResults.development.get(0).setSiteNeedsPublish(projectSiteListResults.getDevelopment().get(0).getSiteNeedsPublish());
	  }else if(projectSiteListResults.getDevelopment().get(0).siteNeedsPublish == null) {
		  projectSiteListResults.development.get(0).setSiteNeedsPublish(financialResultData.get().getDevelopment().get(0).getSiteNeedsPublish());
	  }
	  
	//Project number
	  if(projectSiteListResults.getDevelopment().get(0).projectNumber != null) {
		  projectSiteListResults.development.get(0).setProjectNumber(projectSiteListResults.getDevelopment().get(0).getProjectNumber());
	  }else if(projectSiteListResults.getDevelopment().get(0).projectNumber == null) {
		  projectSiteListResults.development.get(0).setProjectNumber(financialResultData.get().getDevelopment().get(0).getProjectNumber());
	  }
	  
	  //siteVisit
	  if(projectSiteListResults.getDevelopment().get(0).siteVisit != null) {
		  projectSiteListResults.development.get(0).setSiteVisit(projectSiteListResults.getDevelopment().get(0).getSiteVisit());
	  }else if(projectSiteListResults.getDevelopment().get(0).siteVisit == null) {
		  projectSiteListResults.development.get(0).setSiteVisit(financialResultData.get().getDevelopment().get(0).getSiteVisit());
	  }
	  
	//siteEdits
	  if(projectSiteListResults.getDevelopment().get(0).siteEdits != null) {
		  projectSiteListResults.development.get(0).setSiteEdits(projectSiteListResults.getDevelopment().get(0).getSiteEdits());
	  }else if(projectSiteListResults.getDevelopment().get(0).siteEdits == null) {
		  projectSiteListResults.development.get(0).setSiteEdits(financialResultData.get().getDevelopment().get(0).getSiteEdits());
	  }
	  
	  //liveViewUserName
	  if(projectSiteListResults.getDevelopment().get(0).liveViewUserName != null) {
		  projectSiteListResults.development.get(0).setLiveViewUserName(projectSiteListResults.getDevelopment().get(0).getLiveViewUserName());
	  }else if(projectSiteListResults.getDevelopment().get(0).liveViewUserName == null) {
		  projectSiteListResults.development.get(0).setLiveViewUserName(financialResultData.get().getDevelopment().get(0).getLiveViewUserName());
	  }
	  
	//liveViewPassword
	  if(projectSiteListResults.getDevelopment().get(0).liveViewPassword != null) {
		  projectSiteListResults.development.get(0).setLiveViewPassword(projectSiteListResults.getDevelopment().get(0).getLiveViewPassword());
	  }else if(projectSiteListResults.getDevelopment().get(0).liveViewPassword == null) {
		  projectSiteListResults.development.get(0).setLiveViewPassword(financialResultData.get().getDevelopment().get(0).getLiveViewPassword());
	  }
      
	  //liveView
	  if(projectSiteListResults.getDevelopment().get(0).getLiveView() != null) {
		  projectSiteListResults.development.get(0).setLiveView(projectSiteListResults.getDevelopment().get(0).getLiveView());
	  }else if(projectSiteListResults.getDevelopment().get(0).getLiveView() == null) {
		  projectSiteListResults.development.get(0).setLiveView(financialResultData.get().getDevelopment().get(0).getLiveView());
	  }
	  
	  //defaultLinks
	  if(projectSiteListResults.getDevelopment().get(0).getDefaultLinks() != null) {
		  projectSiteListResults.development.get(0).setDefaultLinks(projectSiteListResults.getDevelopment().get(0).getDefaultLinks());
	  }else if(projectSiteListResults.getDevelopment().get(0).getDefaultLinks() == null) {
		  projectSiteListResults.development.get(0).setDefaultLinks(financialResultData.get().getDevelopment().get(0).getDefaultLinks());
	  }
	  
	  //imagePerDate
	  if(projectSiteListResults.getDevelopment().get(0).getImagePerDate() != null) {
		  projectSiteListResults.development.get(0).setImagePerDate(projectSiteListResults.getDevelopment().get(0).getImagePerDate());
	  }else if(projectSiteListResults.getDevelopment().get(0).getImagePerDate() == null) {
		  projectSiteListResults.development.get(0).setImagePerDate(financialResultData.get().getDevelopment().get(0).getImagePerDate());
	  }
	  
	  //siteUsers
	  if(projectSiteListResults.getDevelopment().get(0).getSiteUsers() != null) {
		  projectSiteListResults.development.get(0).setSiteUsers(projectSiteListResults.getDevelopment().get(0).getSiteUsers());
	  }else if(projectSiteListResults.getDevelopment().get(0).getImagePerDate() == null) {
		  projectSiteListResults.development.get(0).setSiteUsers(financialResultData.get().getDevelopment().get(0).getSiteUsers());
	  }
	  
	  
      return projectSiteListRepository.save(projectSiteListResults);
  }
  
  @CrossOrigin(origins = {"http://localhost:3000", "https://projectadmin.carrolldaniel.com", "https://project.carrolldaniel.com"})
  @RequestMapping(method=RequestMethod.PUT, value="/api/projectSiteListUpdateItem/{id}")
  public ProjectSiteList deleteItem(@PathVariable String id, @RequestBody ProjectSiteList projectSiteListResults) {
	  Optional<ProjectSiteList> financialResultData = projectSiteListRepository.findById(id);
	  System.out.println(financialResultData.get().id);
	  projectSiteListResults.setid(id);
	  projectSiteListResults.setProduction(financialResultData.get().getProduction());
	  //siteImage
	  if(projectSiteListResults.getDevelopment().get(0).siteImage != null) {
		  projectSiteListResults.development.get(0).setSiteImage(projectSiteListResults.getDevelopment().get(0).getSiteImage());
	  }else if(projectSiteListResults.getDevelopment().get(0).siteImage == null) {
		  projectSiteListResults.development.get(0).setSiteImage(financialResultData.get().getDevelopment().get(0).getSiteImage());
	  }
	  
	  //siteName
	  if(projectSiteListResults.getDevelopment().get(0).siteName != null) {
		  projectSiteListResults.development.get(0).setSiteName(projectSiteListResults.getDevelopment().get(0).getSiteName());
	  }else if(projectSiteListResults.getDevelopment().get(0).siteName == null) {
		  projectSiteListResults.development.get(0).setSiteName(financialResultData.get().getDevelopment().get(0).getSiteName());
	  }
	  
	  //Project number
	  if(projectSiteListResults.getDevelopment().get(0).projectNumber != null) {
		  projectSiteListResults.development.get(0).setProjectNumber(projectSiteListResults.getDevelopment().get(0).getProjectNumber());
	  }else if(projectSiteListResults.getDevelopment().get(0).projectNumber == null) {
		  projectSiteListResults.development.get(0).setProjectNumber(financialResultData.get().getDevelopment().get(0).getProjectNumber());
	  }
	  
	  //siteVisit
	  if(projectSiteListResults.getDevelopment().get(0).siteVisit != null) {
		  projectSiteListResults.development.get(0).setSiteVisit(projectSiteListResults.getDevelopment().get(0).getSiteVisit());
	  }else if(projectSiteListResults.getDevelopment().get(0).siteVisit == null) {
		  projectSiteListResults.development.get(0).setSiteVisit(financialResultData.get().getDevelopment().get(0).getSiteVisit());
	  }
	  
	//siteEdits
	  if(projectSiteListResults.getDevelopment().get(0).siteEdits != null) {
		  projectSiteListResults.development.get(0).setSiteEdits(projectSiteListResults.getDevelopment().get(0).getSiteEdits());
	  }else if(projectSiteListResults.getDevelopment().get(0).siteEdits == null) {
		  projectSiteListResults.development.get(0).setSiteEdits(financialResultData.get().getDevelopment().get(0).getSiteEdits());
	  }
	  
	  //liveViewUserName
	  if(projectSiteListResults.getDevelopment().get(0).liveViewUserName != null) {
		  projectSiteListResults.development.get(0).setLiveViewUserName(projectSiteListResults.getDevelopment().get(0).getLiveViewUserName());
	  }else if(projectSiteListResults.getDevelopment().get(0).liveViewUserName == null) {
		  projectSiteListResults.development.get(0).setLiveViewUserName(financialResultData.get().getDevelopment().get(0).getLiveViewUserName());
	  }
	  
	  //liveViewPassword
	  if(projectSiteListResults.getDevelopment().get(0).liveViewPassword != null) {
		  projectSiteListResults.development.get(0).setLiveViewPassword(projectSiteListResults.getDevelopment().get(0).getLiveViewPassword());
	  }else if(projectSiteListResults.getDevelopment().get(0).liveViewPassword == null) {
		  projectSiteListResults.development.get(0).setLiveViewPassword(financialResultData.get().getDevelopment().get(0).getLiveViewPassword());
	  }
	  
	  //siteNeedPublish
	  if(projectSiteListResults.getDevelopment().get(0).siteNeedsPublish != null) {
		  projectSiteListResults.development.get(0).setSiteNeedsPublish(projectSiteListResults.getDevelopment().get(0).getSiteNeedsPublish());
	  }else if(projectSiteListResults.getDevelopment().get(0).siteNeedsPublish == null) {
		  projectSiteListResults.development.get(0).setSiteNeedsPublish(financialResultData.get().getDevelopment().get(0).getSiteNeedsPublish());
	  }
      
	  //liveView
	  if(projectSiteListResults.getDevelopment().get(0).getLiveView() != null) {
		  projectSiteListResults.development.get(0).setLiveView(projectSiteListResults.getDevelopment().get(0).getLiveView());
	  }else if(projectSiteListResults.getDevelopment().get(0).getLiveView() == null) {
		  projectSiteListResults.development.get(0).setLiveView(financialResultData.get().getDevelopment().get(0).getLiveView());
	  }
	  
	  //defaultLinks
	  if(projectSiteListResults.getDevelopment().get(0).getDefaultLinks() != null) {
		  projectSiteListResults.development.get(0).setDefaultLinks(projectSiteListResults.getDevelopment().get(0).getDefaultLinks());
	  }else if(projectSiteListResults.getDevelopment().get(0).getDefaultLinks() == null) {
		  projectSiteListResults.development.get(0).setDefaultLinks(financialResultData.get().getDevelopment().get(0).getDefaultLinks());
	  }
	  
	  //imagePerDate
	  if(projectSiteListResults.getDevelopment().get(0).getImagePerDate() != null) {
		  projectSiteListResults.development.get(0).setImagePerDate(projectSiteListResults.getDevelopment().get(0).getImagePerDate());
	  }else if(projectSiteListResults.getDevelopment().get(0).getImagePerDate() == null) {
		  projectSiteListResults.development.get(0).setImagePerDate(financialResultData.get().getDevelopment().get(0).getImagePerDate());
	  }
	  
	  //siteUsers
	  if(projectSiteListResults.getDevelopment().get(0).getSiteUsers() != null) {
		  projectSiteListResults.development.get(0).setSiteUsers(projectSiteListResults.getDevelopment().get(0).getSiteUsers());
	  }else if(projectSiteListResults.getDevelopment().get(0).getImagePerDate() == null) {
		  projectSiteListResults.development.get(0).setSiteUsers(financialResultData.get().getDevelopment().get(0).getSiteUsers());
	  }
	  
	  
      return projectSiteListRepository.save(projectSiteListResults);
  }
  
  @CrossOrigin(origins = {"http://localhost:3000", "https://projectadmin.carrolldaniel.com", "https://project.carrolldaniel.com"})
  @RequestMapping(method=RequestMethod.PUT, value="/api/projectSiteListPublishItem/{id}")
  public ProjectSiteList publishItem(@PathVariable String id, @RequestBody ProjectSiteList projectSiteListResults) {
	  Optional<ProjectSiteList> financialResultData = projectSiteListRepository.findById(id);

	  projectSiteListResults.setid(id);
	  projectSiteListResults.setProduction(projectSiteListResults.getProduction());
	  projectSiteListResults.setDevelopment(projectSiteListResults.getDevelopment());
	
      return projectSiteListRepository.save(projectSiteListResults);
  }
  
  @CrossOrigin(origins = {"http://localhost:3000", "https://project.carrolldaniel.com"})
  @RequestMapping(method=RequestMethod.POST, value="/api/projectSiteListInformation/liveViewLogin/{id}")
  public boolean checkLiveViewLogin(@PathVariable String id, @RequestBody ProjectSiteList projectSiteListResults) {
	  Optional<ProjectSiteList> financialResultData = projectSiteListRepository.findById(id);
	  System.out.println(projectSiteListResults);
	  if(projectSiteListResults.production.get(0).liveViewUserName.equals(financialResultData.get().production.get(0).liveViewUserName) && projectSiteListResults.production.get(0).liveViewPassword.equals(financialResultData.get().production.get(0).liveViewPassword)) {
		  return true;
	  }else {
		  return false;
	  }

  }

  @CrossOrigin(origins = {"http://localhost:3000", "https://projectadmin.carrolldaniel.com", "https://project.carrolldaniel.com"})
  @RequestMapping(method=RequestMethod.DELETE, value="/api/projectSiteListViewPage/{id}")
  public String delete(@PathVariable String id) {
      Optional<ProjectSiteList> product = projectSiteListRepository.findById(id);
      //projectSiteListRepository.delete(product.get());

      return "record deleted";
  }
  
}
