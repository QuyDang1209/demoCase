package com.cg.model;

public enum ERole {
    ADMIN, USER, GUEST;

    public static ERole findERoleBy(String s) {
        for (ERole item : values()) {
            if (item.toString().equals(s)) {
                return item;
            }
        }
        return null;
    }
}
