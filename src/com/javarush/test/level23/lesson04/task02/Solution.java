package com.javarush.test.level23.lesson04.task02;

/* Inner 2
В классе SuperUser метод getDescription должен учитывать страну и город, т.е. возвращать результат аналогичный следующему:
My name is George. I'm from the USA, Seattle.
Используйте возможности иннер класса.
*/
class Solution {

    private final String country;
    private final String city;

    private Solution(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public static void main(String[] args) {
        Solution solution = new Solution("the USA", "Seattle");
        System.out.println(solution.getTrickyUser("George").getDescription());
        System.out.println(solution.getDescriptionOfUser("George"));
    }

    private String getDescriptionOfUser(String name) {
        return getTrickyUser(name).getDescription();
    }

    private SuperUser getTrickyUser(String name) {
        return new SuperUser(name);
    }

    private class SuperUser {

        private final String name;

        SuperUser(String name) {
            this.name = name;
        }

        String getDescription() {
            return String
                .format("My name is %s. I'm from %s, %s.", this.name, Solution.this.country,
                    Solution.this.city);
        }
    }
}
