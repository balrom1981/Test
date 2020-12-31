import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void shouldCalculateRegisteredAndUnderLimit() {
        BonusService service = new BonusService();
        // подготавливаем данные:
        long amount = 1000_60;
        boolean registered = true;
        long expected = 30;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateRegisteredAndOverLimit() {
        BonusService service = new BonusService();
        // подготавливаем данные:
        long amount = 26_000_60;
        boolean registered = true;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateUnRegisteredAndUnderLimit() {
        BonusService service = new BonusService();
        // подготавливаем данные:
        long amount = 26_000_60;
        boolean registered = false;
        long expected = 260;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateUnRegisteredAndOverLimit() {
        BonusService service = new BonusService();
        // подготавливаем данные:
        long amount = 260_000_60;
        boolean registered = false;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }
}