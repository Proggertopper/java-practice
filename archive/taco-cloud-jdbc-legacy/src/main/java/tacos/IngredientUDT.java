package tacos;

import lombok.*;



@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED , force = true)
@AllArgsConstructor

public class IngredientUDT {

    private String id;

    private final String name;

    private final Ingredient.Type type;

}
