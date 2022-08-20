/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hibaa
 */
public class MainTest {
    
    public MainTest() {
    }
    


    /**
     * Test of isValidLength method, of class Main.
     */
    @Test
    public void testIsValidLengthGood() {
      System.out.println("isValidLength");
      ArrayList<Player> warPlayerList = new ArrayList<>();
     
      String name = "reuben";
      boolean expResult = true;
      boolean result = Main.isValidLength(warPlayerList, name);
      assertEquals(expResult, result);

   }
     @Test
    public void testIsValidLengthBad() {
      System.out.println("isValidLength");
      ArrayList<Player> warPlayerList = new ArrayList<>();
     
      String name = "reu";
      boolean expResult = false;
      boolean result = Main.isValidLength(warPlayerList, name);
      assertEquals(expResult, result);

   }
     @Test
    public void testIsValidLengthBoundray() {
      System.out.println("isValidLength");
      ArrayList<Player> warPlayerList = new ArrayList<>();
     
      String name = "reub";
      boolean expResult = true;
      boolean result = Main.isValidLength(warPlayerList, name);
      assertEquals(expResult, result);

   }

    
  
    
}
