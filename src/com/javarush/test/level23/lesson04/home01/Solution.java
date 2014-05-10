package com.javarush.test.level23.lesson04.home01;

import java.util.List;
import java.util.Map;

/* Inner 3
Внутри класса Solution:
1) реализуйте private class TaskDataProvider используя Task и DbMock, цель которого - обновить поле tasks.
2) реализуйте private class NameDataProvider используя String и DbMock, цель которого - обновить поле names.
*/
public class Solution {

    private List<Task> tasks;
    private List<String> names;

   private DbDataProvider taskDataProvider = new TaskDataProvider();
   private DbDataProvider nameDataProvider = new NameDataProvider();

    private class TaskDataProvider implements DbDataProvider {
        @Override
        public void refreshAllData(Map criteria)
        {
            tasks = DbMock.getFakeTasks(ViewMock.getFakeTasksCriteria());
        }
    }

    private class NameDataProvider implements DbDataProvider {
        @Override
        public void refreshAllData(Map criteria)
        {
            names = DbMock.getFakeNames(ViewMock.getFakeNamesCriteria());
        }
    }

    public void refresh() {
        Map taskCriteria = ViewMock.getFakeTasksCriteria();
        taskDataProvider.refreshAllData(taskCriteria);

        Map nameCriteria = ViewMock.getFakeNamesCriteria();
        nameDataProvider.refreshAllData(nameCriteria);
    }

    private interface DbDataProvider<T> {
        void refreshAllData(Map criteria);
    }

    class Task {
    }
}
