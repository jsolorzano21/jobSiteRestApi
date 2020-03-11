
  package com.cdcc.models;
  
  import org.bson.types.ObjectId; import
  org.springframework.data.annotation.Id; import
  org.springframework.data.mongodb.core.index.IndexDirection; import
  org.springframework.data.mongodb.core.index.Indexed; import
  org.springframework.data.mongodb.core.mapping.Document;
  
  @Document(collection = "roles") public class Role {
  
  @Id private ObjectId id;
  
  @Indexed(unique = true, direction = IndexDirection.DESCENDING)
  
  private String role;
  
  public ObjectId getId() { return id; } public void setId(ObjectId id) {
  this.id = id; } public String getRole() { return role; } public void
  setRole(String role) { this.role = role; }
  
  }
 