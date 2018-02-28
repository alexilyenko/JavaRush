package com.javarush.test.level21.lesson02.task01;

/* Определяем адрес сети
1) Даны IP-адрес и маска подсети, необходимо вычислить адрес сети - метод getNetAddress.
Используйте операцию поразрядной конъюнкции (логическое И).
Пример:
IP-адрес:       11000000 10101000 00000001 00000010 (192.168.1.2)
Маска подсети:  11111111 11111111 11111110 00000000 (255.255.254.0)
Адрес сети:     11000000 10101000 00000000 00000000 (192.168.0.0)
2) Реализовать метод print, который выведет в консоль данные в двоичном коде
3) Метод main не участвует в тестировании
*/
class Solution {

  public static void main(String[] args) {
    byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
    byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
    byte[] netAddress = getNetAddress(ip, mask);
    print(ip);          //11000000 10101000 00000001 00000010
    print(mask);        //11111111 11111111 11111110 00000000
    print(netAddress);  //11000000 10101000 00000000 00000000
  }

  private static byte[] getNetAddress(byte[] ip, byte[] mask) {
    byte[] netAddress = new byte[4];
    for (int i = 0; i < netAddress.length; i++) {
      netAddress[i] = (byte) (ip[i] & mask[i]);
    }
    return netAddress;
  }

  private static void print(byte[] bytes) {
    String currentBinary;
    for (byte aByte : bytes) {
      currentBinary = Integer.toBinaryString(256 + (int) aByte);
      System.out.print(currentBinary.substring(currentBinary.length() - 8) + " ");
    }
    System.out.println();
  }
}
