package co.com.asprilla.dillan.Services;

import co.com.asprilla.dillan.Models.GroceryItem;
import co.com.asprilla.dillan.Repository.GroceryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private GroceryRepository groceryRepository;

    // Obtener todos los items
    public ResponseEntity<List<GroceryItem>> getAll() {
        List<GroceryItem> groceryItems = groceryRepository.findAll();
        return groceryItems.isEmpty()
                ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(groceryItems, HttpStatus.OK);
    }

    // Obtener un item por ID
    public ResponseEntity<GroceryItem> getById(String id) {
        Optional<GroceryItem> groceryItem = groceryRepository.findById(id);
        return groceryItem.isPresent()
                ? new ResponseEntity<>(groceryItem.get(), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Insertar un nuevo item
    public ResponseEntity<String> insert(GroceryItem groceryItem) {
        groceryRepository.save(groceryItem);
        return new ResponseEntity<>("Item inserted", HttpStatus.CREATED);
    }

    // Actualizar un item por su ID
    public ResponseEntity<String> update(String id, GroceryItem groceryItem) {
        Optional<GroceryItem> existingItemOptional = groceryRepository.findById(id);

        if (existingItemOptional.isPresent()) {
            GroceryItem existingItem = existingItemOptional.get();

            // Actualiza solo los campos no nulos del cuerpo de la solicitud
            if (groceryItem.getName() != null) {
                existingItem.setName(groceryItem.getName());
            }
            if (groceryItem.getQuantity() != 0) { // Si `quantity` es 0, no lo actualizamos
                existingItem.setQuantity(groceryItem.getQuantity());
            }
            if (groceryItem.getCategory() != null) {
                existingItem.setCategory(groceryItem.getCategory());
            }

            groceryRepository.save(existingItem);
            return new ResponseEntity<>("Item updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Item not found", HttpStatus.NOT_FOUND);
        }
    }


    // Eliminar un item por su ID
    public ResponseEntity<String> delete(String id) {
        if (groceryRepository.existsById(id)) {
            groceryRepository.deleteById(id);
            return new ResponseEntity<>("Item deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Item not found", HttpStatus.NOT_FOUND);
        }
    }

    // Actualizar la cantidad de un item por su ID
    public ResponseEntity<String> updateQuantity(String id, int quantity) {
        Optional<GroceryItem> existingItem = groceryRepository.findById(id);
        if (existingItem.isPresent()) {
            GroceryItem item = existingItem.get();
            item.setQuantity(quantity);
            groceryRepository.save(item);
            return new ResponseEntity<>("Item quantity updated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Item not found", HttpStatus.NOT_FOUND);
        }
    }
}
