package com.javarush.test.level23.lesson08.home01;

import com.javarush.test.level23.lesson08.home01.vo.*;

import java.util.List;

/* Анонимность иногда так приятна!
1. В пакете vo создайте public классы User, Location, Server, Subject, Subscription, которые наследуются от NamedItem
2. В классе Solution для каждого класса создайте свой метод, который возвращает список экземпляров класса.
Например, для класса User это будет - public List<User> getUsers()
Для класса Location это будет - public List<Location> getLocations()
3. Внутри каждого такого метода создайте анонимный класс от AbstractDbSelectExecutor и вызовите его нужный метод.
Подсказка: тело метода должно начинаться так: return new AbstractDbSelectExecutor

4. Пример вывода для User и Location:
Id=5, name='User-5', description=Got by executing 'select * from USER'
Id=1, name='Location-1', description=Got by executing 'select * from LOCATION'

5. Проанализируйте пример вывода и сформируйте правильный query для всех классов.
6. Классы не должны содержать закоментированного кода.
*/


public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        print(solution.getUsers());
        print(solution.getLocations());
        print(solution.getServers());
        print(solution.getSubjects());
        print(solution.getSubscriptions());
    }

    public static void print(List list) {
        String format = "Id=%d, name='%s', description=%s";
        for (Object obj : list) {
            NamedItem item = (NamedItem) obj;
            System.out.println(String.format(format, item.getId(), item.getName(), item.getDescription()));
        }
    }

    public List<User> getUsers() {
            return new AbstractDbSelectExecutor<User>()
            {

                public String getQuery()
                {
                    return "select * from USER";
                }
            }.execute();
        }

    public List<Location> getLocations() {
        return new AbstractDbSelectExecutor<Location>()
        {

            public String getQuery()
            {
                return "select * from LOCATION";
            }
        }.execute();
    }

    public List<Server> getServers() {
        return new AbstractDbSelectExecutor<Server>()
        {

            public String getQuery()
            {
                return "select * from SERVER";
            }
        }.execute();
    }

    public List<Subject> getSubjects() {
        return new AbstractDbSelectExecutor<Subject>()
        {

            public String getQuery()
            {
                return "select * from SUBJECT";
            }
        }.execute();
    }

    public List<Subscription> getSubscriptions() {
        return new AbstractDbSelectExecutor<Subscription>()
        {

            public String getQuery()
            {
                return "select * from SUBSCRIPTION";
            }
        }.execute();
    }
}

