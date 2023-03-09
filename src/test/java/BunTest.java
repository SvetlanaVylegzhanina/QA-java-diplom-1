import org.junit.Before;
import org.junit.Test;
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

    // Проверка названия булочки
    @Test
    public void getNameBunPassed() {
        assertEquals("Неверное значение в поле name", bun.getName(), NAME_BUN);
    }

    // Проверка цены булочки
    @Test
    public void getNamePricePassed() {
        assertEquals("Неверное значение в поле price", bun.getPrice(), PRICE_BUN, 0);
    }

}
