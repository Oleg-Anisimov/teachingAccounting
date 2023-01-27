package me.anisimov.teachingAccounting.util;

import lombok.experimental.UtilityClass;

import java.lang.reflect.Field;

@UtilityClass
public class ReflectionUtils {

    /**
     * Method that deep dive into value of complex field.
     *
     * @param target String with field name in format "fieldX.fieldY.fieldZ"
     * @param origin Origin object that provide field
     * @return Object - field data
     */
    public Object diveForField(String target, Object origin) throws NoSuchFieldException, IllegalAccessException {
        Object object = origin;


        if (isComplexField(target)) {
            String[] fieldNameParts = getFieldNameParts(target);

            for (String s : fieldNameParts) {
                if (object != null) {
                    object = getFieldValue(object, s);
                }
            }

        } else {
            object = getFieldValue(object, target);

        }
        return object;
    }

    private Object getFieldValue(Object object, String s) throws NoSuchFieldException, IllegalAccessException {
        Field field = object.getClass().getDeclaredField(s);
        field.setAccessible(true);
        object = field.get(object);
        return object;
    }

    /**
     *
     * @param field - string parameter that contain field name
     * @return array of string splitted by dot-symbol
     */
    public String[] getFieldNameParts(String field) {
        return field.split("\\.");
    }

    /**
     * Looking up for dots in field name
     * @param fieldName - string parameter that contain field name
     * @return boolean value that indicate complex field name
     */
    public boolean isComplexField(String fieldName) {
        return fieldName.contains(".");
    }

}
