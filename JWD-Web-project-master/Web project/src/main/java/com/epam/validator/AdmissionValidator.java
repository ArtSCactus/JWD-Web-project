package com.epam.validator;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author ArtSCactus
 * @version 1.0
 */
public class AdmissionValidator {

    public boolean isDateCorrect(String dateInStrRepr) {
        try {
            Date dateObj = Date.valueOf(dateInStrRepr);
            Calendar calendar = new GregorianCalendar(Locale.getDefault());
            if (calendar.after(dateObj)) {
                return false;
            } else {
                return true;
            }
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public boolean isLimitCorrect(String longInStrRepr) {
        try {
            long value = Long.parseLong(longInStrRepr);
            if (value <= 0) {
                return false;
            } else {
                return true;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
