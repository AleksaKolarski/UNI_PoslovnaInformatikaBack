package com.projekat.poslovna.controller.value;

import lombok.Getter;

/**
 * Created by milan.miljus on 8/25/19 12:45 PM.
 */
@Getter
public class IdWrapper {

    private int id;

    private IdWrapper(int id) {
        this.id = id;
    }

    public static IdWrapper of(int id) {
        return new IdWrapper(id);
    }
}
