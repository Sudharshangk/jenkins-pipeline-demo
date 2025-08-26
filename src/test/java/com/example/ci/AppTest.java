package com.example.ci;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    void addsNumbers() {
        App app = new App();
        assertEquals(5, app.add(2, 3));
    }

    @Test
    void addsWithZero() {
        App app = new App();
        assertEquals(7, app.add(7, 0));  
        assertEquals(0, app.add(0, 0));   
    }

    @Test
    void addsNegativeNumbers() {
        App app = new App();
        assertEquals(-5, app.add(-2, -3)); 
        assertEquals(1, app.add(4, -3));   
    }

}
