package co.com.asprilla.dillan.Repository;

import co.com.asprilla.dillan.Models.GroceryItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroceryRepository extends MongoRepository<GroceryItem, String> {


}
