package com.simbirsoft.yashkin.accountmanager.util;

public class Owners {
    public static String getFullName(String firstName, String lastName) {
        return (firstName + lastName).replaceAll(" ", "");
    }

    public static String getFullName(String name) {
        return name.replaceAll(" ", "");
    }


}
