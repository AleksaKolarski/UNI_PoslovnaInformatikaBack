package com.projekat.poslovna.utils;

import lombok.experimental.UtilityClass;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by milan.miljus on 8/25/19 1:33 PM.
 */
@UtilityClass
public class Utils {

    public static boolean isNullOrZero(Integer integer) {
        return integer == null || integer == 0;
    }

    public static Timestamp getCurrentTimestamp() {
        final Date date = new Date();
        long time = date.getTime();
        return new Timestamp(time);
    }

}
