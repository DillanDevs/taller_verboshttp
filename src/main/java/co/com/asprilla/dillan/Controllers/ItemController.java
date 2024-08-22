package co.com.asprilla.dillan.Controllers;

import co.com.asprilla.dillan.Models.GroceryItem;
import co.com.asprilla.dillan.Services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    ItemService itemService;

    // Obtener todos los items
    @GetMapping("/getAll")
    public ResponseEntity<List<GroceryItem>> getAll() {
        return itemService.getAll();
    }

    // Obtener un item por ID
    @GetMapping("/get/{id}")
    public ResponseEntity<GroceryItem> getById(@PathVariable String id) {
        return itemService.getById(id);
    }

    // Insertar un nuevo item
    @PostMapping("/insert")
    public ResponseEntity<String> insert(@RequestBody GroceryItem groceryItem) {
        return itemService.insert(groceryItem);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable String id, @RequestBody GroceryItem groceryItem) {
        return itemService.update(id, groceryItem);
    }

    // Eliminar un item por su ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        return itemService.delete(id);
    }

    // Actualizar la cantidad de un item por su ID
    @PatchMapping("/update/{id}/quantity")
    public ResponseEntity<String> updateQuantity(@PathVariable String id, @RequestParam int quantity) {
        return itemService.updateQuantity(id, quantity);
    }

    // Manejo de la solicitud HEAD
    @RequestMapping(value = "/", method = RequestMethod.HEAD)
    public ResponseEntity<Void> handleHeadRequest() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }
}
