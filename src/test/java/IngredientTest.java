import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {

    private Ingredient ingredient;
    private final IngredientType typeIngredient;
    private final String nameIngredient;
    private final float priceIngredient;

    public IngredientTest(IngredientType typeIngredient, String nameIngredient, float priceIngredient) {
        this.typeIngredient = typeIngredient;
        this.nameIngredient = nameIngredient;
        this.priceIngredient = priceIngredient;
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(typeIngredient, nameIngredient, priceIngredient);
    }

    @Parameterized.Parameters // Тестовые данные
    public static Object[][] getIngredientData() {
        return new Object[][]{
                {SAUCE, "Соус Spicy-X", 90},
                {SAUCE, "Соус фирменный Space Sauce", 80},
                {FILLING, "Говяжий метеорит (отбивная)", 3000},
                {FILLING, "Плоды Фалленианского дерева", 874},
                {FILLING, "Сыр с астероидной плесенью", 4142},
        };
    }

    @Test
    // Проверка названия ингредиента
    public void getNameIngredientPassed() {
        assertEquals("Неверное значение в поле name", ingredient.getName(), nameIngredient);
    }

    // Проверка типа ингредиента
    @Test
    public void getTypeIngredientPassed() {
        assertEquals("Неверное значение в поле type", ingredient.getType(), typeIngredient);
    }

    // Проверка цены ингридиента
    @Test
    public void getPriceIngredient() {
        assertEquals("Неверное значение в поле price", ingredient.getPrice(), priceIngredient, 0);
    }

}
