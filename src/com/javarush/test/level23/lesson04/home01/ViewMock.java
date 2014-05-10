package com.javarush.test.level23.lesson04.home01;

import java.util.HashMap;
import java.util.Map;

public class ViewMock {
    private static final Map FAKE_TASKS_CRITERIA = new HashMap();
    private static final Map FAKE_NAMES_CRITERIA = new HashMap();

    public static Map getFakeTasksCriteria() {
        return FAKE_TASKS_CRITERIA;
    }

    public static Map getFakeNamesCriteria() {
        return FAKE_NAMES_CRITERIA;
    }
}
