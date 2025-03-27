package com.example.demo.enums;

public enum Role {
    BASE_EMPLOYEE("base_employee"),
    PROGRAM_DIRECTOR("program_director");

    private final String value;

    Role(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    // Static method to get Role from a string (case-insensitive)
    public static Role fromString(String role) {
        for (Role r : Role.values()) {
            if (r.getValue().equalsIgnoreCase(role)) {
                return r;
            }
        }
        throw new IllegalArgumentException("Unexpected role value: " + role);
    }
}

