import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private Bun bun;
    private static final String NAME_BUN = "Краторная булка N-200i";
    private static final float PRICE_BUN = 1255;

    @Before
    public void setUp() {
        bun = new Bun(NAME_BUN, PRICE_BUN);
    }

    @Test
    @DisplayName("Проверка названия булочки")
    public void getNameBunPassed() {
        assertEquals("Неверное значение в поле name", bun.getName(), NAME_BUN);
    }

    @Test
   @DisplayName("Проверка цены булочки")
    public void getNamePricePassed() {
        assertEquals("Неверное значение в поле price", bun.getPrice(), PRICE_BUN, 0);
    }

}
