package edu.umb.cs680.hw04;

import static org.junit.Assert.*;
import org.junit.Test;

public class FanTest {
    @Test
    public void testFanBehavior() {
        Fan fan = new Fan();
        StringBuilder log = new StringBuilder();

        // Fan starts off
        log.append("Fan is initially off.");
        assertEquals(log.toString(), log.toString());

        // Pull chain: Off -> Low
        fan.pullChain();
        log.append("Turning fan to low.");
        assertEquals(log.toString(), log.toString());

        // Pull chain: Low -> Medium
        fan.pullChain();
        log.append("Turning fan to medium.");
        assertEquals(log.toString(), log.toString());

        // Pull chain: Medium -> High
        fan.pullChain();
        log.append("Turning fan to high.");
        assertEquals(log.toString(), log.toString());

        // Pull chain: High -> Off
        fan.pullChain();
        log.append("Turning fan off.");
        assertEquals(log.toString(), log.toString());
    }
}
