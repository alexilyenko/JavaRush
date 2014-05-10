package com.javarush.test.level23.lesson04.task02;

/* Inner 2
В классе SuperUser метод getDescription должен учитывать страну и город, т.е. возвращать результат аналогичный следующему:
My name is George. I'm from the USA, Seattle.
Используйте возможности иннер класса.
*/
public class Solution {
    private String country;
    private String city;

    public Solution(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public String getDescriptionOfUser(String name) {
        return getTrickyUser(name).getDescription();
    }

    public SuperUser getTrickyUser(String name) {
        return new SuperUser(name);
    }

    private class SuperUser {
        private String name;

        public SuperUser(String name) {
            this.name = name;
        }

        public String getDescription() {
            return String.format("My name is %s. I'm from %s, %s.", this.name, Solution.this.country, Solution.this.city);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution("the USA", "Seattle");
        System.out.println(solution.getTrickyUser("George").getDescription());
        System.out.println(solution.getDescriptionOfUser("George"));
    }
}
