
  package com.cdcc.repository;
  
  import org.springframework.data.mongodb.repository.MongoRepository; import
  com.cdcc.models.Users;
  
  public interface UsersRepository extends MongoRepository<Users, String> {
  
  Users findByEmail(String email); }
 