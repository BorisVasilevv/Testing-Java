import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class IntegerDecodeTests{
    @Test
    public void testEmpty(){
        assertThrows(NumberFormatException.class, () -> Integer.decode(""));
    }
    @Test
    public void testZeroes(){
        assertEquals(0, Integer.decode("00000"));
    }
    @Test
    public void testNegativeValue(){
        assertEquals(-1, Integer.decode("-1"));
        assertEquals(-7, Integer.decode("-7"));
        assertEquals(-18, Integer.decode("-18"));
        assertEquals(-154, Integer.decode("-154"));
        assertEquals(-1600, Integer.decode("-1600"));


        assertNotEquals(-8, Integer.decode("-1"));
        assertNotEquals(-24, Integer.decode("-7"));
        assertNotEquals(-17, Integer.decode("-18"));
        assertNotEquals(-184, Integer.decode("-154"));
        assertNotEquals(-1690, Integer.decode("-1600"));
    }
    @Test
    public void testPositiveValue(){
        assertEquals(1, Integer.decode("1"));
        assertEquals(7, Integer.decode("7"));
        assertEquals(18, Integer.decode("18"));
        assertEquals(154, Integer.decode("154"));
        assertEquals(1600, Integer.decode("1600"));


        assertNotEquals(8, Integer.decode("1"));
        assertNotEquals(24, Integer.decode("7"));
        assertNotEquals(17, Integer.decode("18"));
        assertNotEquals(184, Integer.decode("154"));
        assertNotEquals(1690, Integer.decode("1600"));
    }

    @Test
    void TestOcta(){
        Assertions.assertEquals(18, Integer.decode("022"));
        Assertions.assertEquals(42, Integer.decode("052"));
        Assertions.assertEquals(67, Integer.decode("0103"));
        Assertions.assertEquals(6478, Integer.decode("014516"));
    }
    @Test
    void TestNegativeOcta(){
        Assertions.assertEquals(-10, Integer.decode("-012"));

        Assertions.assertEquals(-42, Integer.decode("-052"));
        Assertions.assertEquals(-67, Integer.decode("-0103"));
        Assertions.assertEquals(-6478, Integer.decode("-014516"));
    }

    @Test
    public void testHex(){
        assertEquals(164, Integer.decode("0xA4"));
        assertEquals(168, Integer.decode("0XA8"));
        assertEquals(18, Integer.decode("#12"));
    }

    @Test
    public void testNegativeHex(){
        assertEquals(-164, Integer.decode("-0xA4"));
        assertEquals(-168, Integer.decode("-0XA8"));
        assertEquals(-18, Integer.decode("-#12"));
    }



    @Test
    public void testMinValue(){
        assertEquals(Optional.of(Integer.MIN_VALUE), Optional.of(Integer.decode("-2147483648")));
    }
    @Test
    public void testMaxValue(){
        assertEquals(Optional.of(Integer.MIN_VALUE), Optional.of(Integer.decode("-2147483648")));
    }
    @Test
    public void testIncorrectString() {
        assertThrows(NumberFormatException.class, () -> Integer.decode("yes"));
        assertThrows(NumberFormatException.class, () -> Integer.decode("not"));
        assertThrows(NumberFormatException.class, () -> Integer.decode("shdrtf"));
        assertThrows(NumberFormatException.class, () -> Integer.decode("sfdghd"));
        assertThrows(NumberFormatException.class, () -> Integer.decode("--geg"));
    }

    @Test
    public void testNull() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            Integer.decode(null);
        });
    }
}
