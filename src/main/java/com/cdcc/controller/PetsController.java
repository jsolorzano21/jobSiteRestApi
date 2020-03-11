/*
 * package com.cdcc.controller;
 * 
 * import org.bson.types.ObjectId; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.web.bind.annotation.CrossOrigin; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.cdcc.models.Pets; import com.cdcc.repository.PetsRepository;
 * 
 * import javax.validation.Valid; import java.util.List; import
 * java.util.Optional;
 * 
 * @RestController public class PetsController {
 * 
 * @Autowired PetsRepository petRepository;
 * 
 * @CrossOrigin(origins = "http://localhost:3000")
 * 
 * @RequestMapping(method=RequestMethod.GET, value="/api/pets") public
 * Iterable<Pets> product() { return petRepository.findAll(); }
 * 
 * @RequestMapping(method=RequestMethod.POST, value="/api/pets") public String
 * save(@RequestBody Pets pet) { petRepository.save(pet);
 * 
 * return pet.get_id(); }
 * 
 * @RequestMapping(method=RequestMethod.GET, value="/api/pets/{id}")
 * 
 * @CrossOrigin(origins = "http://localhost:3000") public Optional<Pets>
 * show(@PathVariable String id) { return petRepository.findById(id); }
 * 
 * @RequestMapping(method=RequestMethod.PUT, value="/api/pets/{id}") public Pets
 * update(@PathVariable String id, @RequestBody Pets petsValue) { Optional<Pets>
 * pet = petRepository.findById(id); if(petsValue.getName() != null)
 * pet.get().setName(petsValue.getName()); if(petsValue.getDescription() !=
 * null) pet.get().setDescription(petsValue.getDescription());
 * if(petsValue.getHeaders() != null)
 * pet.get().setHeaders(petsValue.getHeaders()); if(petsValue.getHomePage() !=
 * null) pet.get().setHomePage(petsValue.getHomePage());
 * if(petsValue.getAboutPage() != null)
 * pet.get().setAboutPage(petsValue.getAboutPage()); if(petsValue.getSpecies()
 * != null) pet.get().setSpecies(petsValue.getSpecies());
 * if(petsValue.getBreed() != null) pet.get().setBreed(petsValue.getBreed());
 * petRepository.save(pet.get()); return pet.get(); }
 * 
 * @RequestMapping(method=RequestMethod.DELETE, value="/api/pets/{id}") public
 * String delete(@PathVariable String id) { Optional<Pets> product =
 * petRepository.findById(id); petRepository.delete(product.get());
 * 
 * return "product deleted"; }
 * 
 * }
 */