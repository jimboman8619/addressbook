package boot;

import org.springframework.beans.BeanUtils;


import java.lang.reflect.Field;
import java.util.*;

public class PersonService {
    /**
     * Копирование заполненных полей из одного объекта в др
     * @param source объект истоочник
     * @param destination объект куда нужно скопировать
     */
    public void copyNonNullProperties(Object source, Object destination) throws IllegalAccessException {
        Field[] fields = source.getClass().getDeclaredFields();
        Set<String> emptyNames = new HashSet<String>();
        for (Field field : fields) {
            field.setAccessible(true);
            Object srcValue = field.get(source);
            if (srcValue == null) emptyNames.add(field.getName());
        }
        String[] ignoredFields = new String[emptyNames.size()];

        BeanUtils.copyProperties(source, destination, emptyNames.toArray(ignoredFields));
    }
}
