
  package com.cdcc.repository;
  
  import org.springframework.data.mongodb.repository.MongoRepository;
  
  import com.cdcc.models.Role;
  
  public interface RoleRepository extends MongoRepository<Role, String> {
  
  Role findByRole(String role); }
 