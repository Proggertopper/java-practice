package tacos.web;

import java.util.HashMap;
import java.util.Map;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import tacos.Ingredient;
import tacos.Ingredient.Type;
import tacos.IngredientUDT;
import tacos.TacoUDRUtils;
import tacos.data.IngredientRepository;


@Component
public class IngredientByIdConverter implements Converter<String, IngredientUDT> {

    private IngredientRepository  ingredientRepository;

    public IngredientByIdConverter(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }


    @Override
    public IngredientUDT convert(String id) {
        Ingredient ing = ingredientRepository.findById(id).orElse(null);
        if (ing == null) return null;
        return TacoUDRUtils.toIngredientUDT(ing);
    }

}
