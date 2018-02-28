package com.javarush.test.level21.lesson02.task02;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* Сравниваем модификаторы
Реализовать логику метода isAllModifiersContainSpecificModifier, который проверяет,
содержит ли переданный параметр allModifiers значение конкретного модификатора specificModifier
*/
class Solution {

  @SuppressWarnings("ConstantConditions")
  public static void main(String[] args) {
    int modifiersOfThisClass = Solution.class.getModifiers();

    System.out.println(
        isAllModifiersContainSpecificModifier(modifiersOfThisClass, Modifier.PUBLIC));   //true
    System.out.println(
        isAllModifiersContainSpecificModifier(modifiersOfThisClass, Modifier.STATIC));   //false

    int modifiersOfMethod = getMainMethod().getModifiers();
    System.out.println(
        isAllModifiersContainSpecificModifier(modifiersOfMethod, Modifier.STATIC));      //true
  }

  private static boolean isAllModifiersContainSpecificModifier(int allModifiers,
      int specificModifier) {
    byte[] allModifiersBytes = ByteBuffer.allocate(4).putInt(allModifiers).array();
    byte[] specificModifierBytes = ByteBuffer.allocate(4).putInt(specificModifier).array();
    byte[] result = new byte[4];
    for (int i = 0; i < result.length; i++) {
      result[i] = (byte) (allModifiersBytes[i] & specificModifierBytes[i]);
    }
    return Arrays.equals(result, specificModifierBytes);
  }

  private static Method getMainMethod() {
    Method[] methods = Solution.class.getDeclaredMethods();
    for (Method method : methods) {
      if (method.getName().equalsIgnoreCase("main")) {
        return method;
      }
    }

    return null;
  }
}
