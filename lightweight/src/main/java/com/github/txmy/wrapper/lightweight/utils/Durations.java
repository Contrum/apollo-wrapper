package com.github.txmy.wrapper.lightweight.utils;

import java.time.Duration;

public final class Durations {

    private Durations() {
    }



    public static String of(Duration duration) {
        long seconds = duration.getSeconds();
        long nanos = duration.getNano();

        String result;
        if (nanos == 0) {
            result = seconds + "s";
        } else {
            result = String.format("%d.%09ds", seconds, nanos).replaceAll("0+$", "").replaceAll("\\.$", "");
        }

        return result;
    }
}
