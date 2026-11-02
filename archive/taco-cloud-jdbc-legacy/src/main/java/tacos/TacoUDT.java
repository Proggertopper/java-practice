package tacos;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TacoUDT {

    private  String name;

    private  List<IngredientUDT> ingredients;

}
