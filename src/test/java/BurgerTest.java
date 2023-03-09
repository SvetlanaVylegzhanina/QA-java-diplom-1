import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger stellarBurger;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient1;

    @Mock
    private Ingredient ingredient2;

    private static final String NAME_BUN = "Флюоресцентная булка R2-D3";
    private static final String NAME_INGREDIENT1 = "Соус фирменный Space Sauce";
    private static final String NAME_INGREDIENT2 = "Мясо бессмертных моллюсков Protostomia";

    @Before
    public void setUp() {
        stellarBurger = new Burger();
    }

    // Проверка добавления булочки
    @Test
    public void setBunPassed() {
        stellarBurger.setBuns(bun);

        assertEquals("Неверное значение в поле bun", bun, stellarBurger.bun);
    }

    // Проверка добавления ингредиентов
    @Test
    public void addIngredientPassed() {
        stellarBurger.addIngredient(ingredient1);
        stellarBurger.addIngredient(ingredient2);

        assertEquals("Неверное количество ингредиентов", 2, stellarBurger.ingredients.size());
    }

    // Проверка удаления ингредиента
    @Test
    public void removeIngredientPassed() {
        stellarBurger.addIngredient(ingredient1);
        stellarBurger.addIngredient(ingredient2);
        stellarBurger.removeIngredient(1);

        assertEquals("Неверное количество ингредиентов", 1, stellarBurger.ingredients.size());
    }

    // Проверка перемещения ингредиента
    @Test
    public void moveIngredientPassed() {
        stellarBurger.addIngredient(ingredient1);
        stellarBurger.addIngredient(ingredient2);
        stellarBurger.moveIngredient(1, 0);

        assertEquals("Неверная позиция ингредиента", ingredient2, stellarBurger.ingredients.get(0));
    }

    // Проверка получения цены бургера
    @Test
    public void getPricePassed() {
        stellarBurger.setBuns(bun);
        stellarBurger.addIngredient(ingredient1);
        stellarBurger.addIngredient(ingredient2);

        Mockito.when(bun.getPrice()).thenReturn(50F);
        Mockito.when(ingredient1.getPrice()).thenReturn(120F);
        Mockito.when(ingredient2.getPrice()).thenReturn(80F);

        float expectedResult = 50F * 2 + 120F + 80F;

        assertEquals("Неверная цена бургера", expectedResult, stellarBurger.getPrice(), 0);
    }

    // Проверка печати чека с информацией о бургере
    @Test
    public void getReceiptPassed() {
        stellarBurger.setBuns(bun);
        stellarBurger.addIngredient(ingredient1);
        stellarBurger.addIngredient(ingredient2);

        Mockito.when(bun.getPrice()).thenReturn(50F);
        Mockito.when(bun.getName()).thenReturn(NAME_BUN);

        Mockito.when(ingredient1.getName()).thenReturn(NAME_INGREDIENT1);
        Mockito.when(ingredient1.getType()).thenReturn(SAUCE);
        Mockito.when(ingredient1.getPrice()).thenReturn(120F);

        Mockito.when(ingredient2.getName()).thenReturn(NAME_INGREDIENT2);
        Mockito.when(ingredient2.getType()).thenReturn(FILLING);
        Mockito.when(ingredient2.getPrice()).thenReturn(80F);

        String expected = String.format("(==== %s ====)%n", bun.getName()) +
                String.format("= %s %s =%n", ingredient1.getType().toString().toLowerCase(), ingredient1.getName()) +
                String.format("= %s %s =%n", ingredient2.getType().toString().toLowerCase(), ingredient2.getName()) +
                String.format("(==== %s ====)%n", bun.getName()) +
                String.format("%nPrice: %f%n", stellarBurger.getPrice());

        assertEquals(expected, stellarBurger.getReceipt());
    }

}
