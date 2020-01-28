package com.epam;

import java.sql.Date;
import java.time.Clock;
import java.time.LocalDate;

//Only for temporal use, just to test some small features
public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        System.out.println(Date.valueOf(LocalDate.now(Clock.systemDefaultZone())));
    }
    }
