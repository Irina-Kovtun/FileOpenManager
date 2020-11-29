package ru.netology.manager;

import java.util.*;

public class FileOpenManager {
    private Map<String, String> map = new HashMap<>();

    // 1. Метод - регистрировать новое приложение для открытия файлов с определённым расширением.
    public void addToMap(String key, String value) {
        map.put(key.toLowerCase(), value);
    }

    // 2. Метод -  получение названия приложения, предназначенного для открытия файла с определённым расширением.
    public String getValue(String key) {
        String value = map.get(key);
        return value;
    }

    // 3.Метод - удалять привязку приложения к определённому расширению.
    public String removeKey(String key) {
        String removed_value = map.remove(key);
        return removed_value;
    }

    // 4. Метод - получать список всех зарегистрированных расширений, к которым привязаны приложения для открытия.
    public Collection<String> showAllKeys() {
        Set<String> keys = map.keySet();
        return keys;
    }

    //5. Метод - получать список всех приложений, которые привязаны к каким-либо расширениям
    public Collection<String> showAllValues() {
        List<String> values = new ArrayList<>(map.values());
        return values;
    }

    //вспомогательный метод для выведения всех наборов "ключ-значение"
    public List showAll() {
        List<Map.Entry<String, String>> allList = new ArrayList<>(map.entrySet());
        return allList;
    }
}
