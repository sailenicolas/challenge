package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MainTest {

    /**
     * Method under test: {@link Main#concat(String[])}
     */
    @Test
    void testConcat() {
        // Arrange
        String[] array = new String[]{"FirstWord", "SecondWord", "THIRDWORD"};

        // Act
        String concat = Main.concat( array );

        // Assert
        assertEquals( "firstword secondword thirdword", concat);

    }

    /**
     * Method under test: {@link Main#concat(String[])}
     */
    @Test
    void testConcat2() {
        // Arrange
        String[] array = new String[]{"Array"};

        // Act
        String concat = Main.concat( array );

        // Assert
        assertEquals( "array", concat );
    }
}

