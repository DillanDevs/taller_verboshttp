package co.com.asprilla.dillan.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "groceryItems")
public class GroceryItem {
    private String id;
    private String name;
    private int quantity;
    private String category;

}
