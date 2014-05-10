package com.javarush.test.level24.lesson06.home02;

import java.util.List;

/* Как избежать Copy+Paste
В классе Dog реализуйте логику метода toSayable, которая описана в джавадоке.
*/
public class Solution {
    public static void main(String[] args) {
        List<Pet> pet = Util.getPets();
        List<Sayable> pets = Util.convertPetToSayable(pet);
        Util.printDialog(pets);
    }
}
