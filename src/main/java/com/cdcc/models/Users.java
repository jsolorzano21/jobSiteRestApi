
  package com.cdcc.models;
  
  import java.util.Set;
  
  import org.bson.types.ObjectId; import
  org.springframework.data.annotation.Id; import
  org.springframework.data.mongodb.core.index.IndexDirection; import
  org.springframework.data.mongodb.core.index.Indexed; import
  org.springframework.data.mongodb.core.mapping.DBRef; import
  org.springframework.data.mongodb.core.mapping.Document;
  
  @Document(collection = "user") public class Users {
  
  @Id public ObjectId _id;
  
  @Indexed(unique = true, direction = IndexDirection.DESCENDING) private String
  email; public String password; private String fullname; private boolean
  enabled;
  
  @DBRef private Set<Role> roles;
  
  public ObjectId getId() { return _id; } public void setId(ObjectId _id) {
  this._id = _id; } public String getEmail() { return email; } public void
  setEmail(String email) { this.email = email; } public String getPassword() {
  return password; } public void setPassword(String password) { this.password =
  password; } public String getFullname() { return fullname; } public void
  setFullname(String fullname) { this.fullname = fullname; } public boolean
  isEnabled() { return enabled; } public void setEnabled(boolean enabled) {
  this.enabled = enabled; } public Set<Role> getRoles() { return roles; }
  public void setRoles(Set<Role> roles) { this.roles = roles; }
  
  }
 