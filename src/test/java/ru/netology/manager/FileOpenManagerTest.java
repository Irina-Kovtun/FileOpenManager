package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileOpenManagerTest {
    private FileOpenManager manager = new FileOpenManager();

    private String[] first = new String[]{".jpg", "Paint"};
    private String[] second = new String[]{".doc", "Miscrosoft Word"};
    private String[] third = new String[]{".DOC", "Open Office"};
    private String[] forth = new String[]{".xls", "Microsoft Excel"};

    @BeforeEach
    void ShouldAddAppToMap() {
        manager.addToMap(first[0], first[1]);
        manager.addToMap(second[0], second[1]);
        manager.addToMap(third[0], third[1]);
        manager.addToMap(forth[0], forth[1]);
    }
    // 2. Проверка метода для получения названия приложения, предназначенного для открытия файла с определённым расширением.
    @Test
    void shouldGetValue() {
        String expected = "Microsoft Excel";
        String actual = manager.getValue(forth[0]);
        assertEquals(expected, actual);
        System.out.println("Value: " + actual);
    }
    // 3.Проверка метода для удаления привязки приложения к определённому расширению.
    @Test
    void shouldRemoveKey() {
        String expected = "Paint";
        String actual = manager.removeKey(first[0]);
        assertEquals(expected, actual);
        System.out.println("New map is: " + manager.showAll());
    }

    // 4. проверка метода для получения списка всех зарегистрированных расширений, к которым привязаны приложения для открытия.
    @Test
    void shouldShowAllKeys() {
        List<String> expected = new ArrayList<>(List.of(".jpg", ".xls", ".doc"));
        List<String> actual = new ArrayList<>(manager.showAllKeys());
        Collections.sort(expected);
        Collections.sort(actual);
        assertIterableEquals(expected, actual);
        System.out.println("Расширения: " + actual);
    }

    //5. проверка метода для получения списка всех приложений, которые привязаны к каким-либо расширениям
    @Test
    void shouldShowAllValues() {
        List<String> expected = new ArrayList<>(List.of("Paint", "Open Office", "Microsoft Excel"));
        List<String> actual = new ArrayList<>(manager.showAllValues());
        Collections.sort(expected);
        Collections.sort(actual);
        assertIterableEquals(expected, actual);
        System.out.println("Приложения: " + actual);
    }
}