package com.vass.reactiveservice.mapper;

import static java.util.Calendar.DATE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface DateToAgeMapper {
    default Integer asInteger(LocalDateTime date) {
        if (date != null) {
            return getDiffYears(date, LocalDateTime.now());
        } else {
            return 0;
        }
    }

    static int getDiffYears(LocalDateTime first, LocalDateTime last) {
        Calendar a = getCalendar(first);
        Calendar b = getCalendar(last);
        int diff = b.get(YEAR) - a.get(YEAR);
        if (a.get(MONTH) > b.get(MONTH) ||
            (a.get(MONTH) == b.get(MONTH) && a.get(DATE) > b.get(DATE))) {
            diff--;
        }
        return diff;
    }

    static Calendar getCalendar(LocalDateTime date) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTime(Date.from(date.toInstant(ZoneOffset.UTC)));
        return cal;
    }
}
