package com.challenge.utils.constants;

import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor
public enum Resources {

    CREATE_USER("/posts"),
    PERFORM_ACTION_USER("/posts/{id}");

    private final String value;

}
