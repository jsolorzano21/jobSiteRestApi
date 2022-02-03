package com.cdcc.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.cdcc.models.ProjectSiteList;


public interface ProjectSiteListRepository extends MongoRepository<ProjectSiteList, String> {
	@Override
	void delete(ProjectSiteList deleted);

}