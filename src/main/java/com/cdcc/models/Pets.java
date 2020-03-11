/*
 * package com.cdcc.models;
 * 
 * import java.util.List;
 * 
 * import org.bson.types.ObjectId; import
 * org.springframework.data.annotation.Id; import
 * org.springframework.data.mongodb.core.mapping.Document;
 * 
 * @Document(collection = "pets") public class Pets {
 * 
 * @Id public ObjectId _id;
 * 
 * public String name; public String description; public List<String> headers;
 * public List<String> homePage; public List<String> aboutPage; public String
 * species; public String breed;
 * 
 * // Constructors public Pets() { }
 * 
 * public Pets(ObjectId _id, String name, String description, List<String>
 * headers, List<String> homePage, List<String> aboutPage, String species,
 * String breed) { this._id = _id; this.name = name; this.description =
 * description; this.headers = headers; this.homePage = homePage; this.aboutPage
 * = aboutPage; this.species = species; this.breed = breed; }
 * 
 * // ObjectId needs to be converted to string public String get_id() { return
 * _id.toHexString(); }
 * 
 * public void set_id(ObjectId _id) { this._id = _id; }
 * 
 * public String getName() { return name; }
 * 
 * public void setName(String name) { this.name = name; }
 * 
 * public String getDescription() { return description; }
 * 
 * public void setDescription(String description) { this.description =
 * description; }
 * 
 * public List<String> getHeaders() { return headers; }
 * 
 * public void setHeaders(List<String> headers) { this.headers = headers; }
 * 
 * 
 * public List<String> getHomePage() { return homePage; }
 * 
 * public void setHomePage(List<String> homePage) { this.homePage = homePage; }
 * 
 * 
 * public List<String> getAboutPage() { return aboutPage; }
 * 
 * public void setAboutPage(List<String> aboutPage) { this.aboutPage =
 * aboutPage; }
 * 
 * public String getSpecies() { return species; }
 * 
 * public void setSpecies(String species) { this.species = species; }
 * 
 * public String getBreed() { return breed; }
 * 
 * public void setBreed(String breed) { this.breed = breed; } }
 */