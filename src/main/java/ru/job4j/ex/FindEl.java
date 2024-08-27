package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int result = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                result = i;
                break;
            }
        }
        if (result == -1) {
            throw new ElementNotFoundException("Element " + key + " not found");
        }
        return result;
    }

    public static void main(String[] args) {
        try {
            String[] value = new String[]{"as", "sg"};
            System.out.println(indexOf(value, "\"a\""));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}