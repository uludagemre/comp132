package test;

import items.*;

public class Test {

    public static void main(String[] args) {
        //!!! Errors in the lines below will be solved when you implement the desired classes
    
        // Initialize armor, sword and bow objects
        Armor armor = new Armor(50, 200);
        Sword sword = new Sword(20, 40);
        Bow bow = new Bow(5, 2, 5);
        
        System.out.println("Initially: ");
        System.out.println(armor);
        System.out.println(sword);
        System.out.println(bow);
    
        // Use the armor, get hit and print its information
        armor.useItem();
        System.out.println("Armor is worn.");
        armor.getHit(50);
        System.out.println("Armor is hit, defense points reduced by 50.");
        System.out.println(armor);
        
        // Upgrade the armor and print its information
        armor.upgrade();
        System.out.println("Armor is upgraded");
        System.out.println(armor);
        
        // Use the sword and print its information
        sword.useItem();
        System.out.println(sword);
        
        // Throw 6 arrows
        for(int i=1; i <= 6; i++) {
        	bow.useItem();
        }
            
        // Print the arrow's information before and after an upgrade
        System.out.println(bow);
        bow.upgrade();
        System.out.println("Bow is upgraded");
        System.out.println(bow);
        
              
    }
}
