package br.com.deteccaoqueda.utils

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.*
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.time.temporal.Temporal
import java.time.temporal.TemporalAdjusters
import java.util.*


fun LocalDateTime.toDate(): String {
        return this.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
    }

    fun String.toLocalDate(pattern: String = "dd-MM-yyyy HH:mm:ss"): LocalDate {
        return this.fromString(pattern).toLocalDate()
    }

    fun LocalDate.toStringDate(pattern: String = "dd-MM-yyyy HH:mm:ss"): String {
        return this.format(DateTimeFormatter.ofPattern(pattern))
    }

    fun LocalDate.toStartOfDay(): Instant {
        return this.atStartOfDay().toInstant(ZoneOffset.UTC)
    }

    fun LocalDate.toEndOfDay(): Instant {
        return LocalDateTime.of(this, LocalTime.of(23, 59, 59, 999000)).toInstant(ZoneOffset.UTC)
    }

    fun Instant.toLocalDate(): LocalDate {
        return LocalDate.ofInstant(this, ZoneOffset.UTC)

    }

    fun Instant.toLocalDateTime(): LocalDateTime {
        return LocalDateTime.ofInstant(this, ZoneOffset.UTC)
    }

    fun String.fromString(pattern: String = "yyyy-MM-dd HH:mm:ss"): LocalDateTime {
        return SimpleDateFormat(pattern).parse(this).toInstant().atZone(ZoneOffset.UTC).toLocalDateTime()
    }

    fun String.toInstantFromString(pattern: String = "yyyy-MM-dd HH:mm:ss"): Instant {
        return SimpleDateFormat(pattern).parse(this).toInstant()
    }

    fun LocalDateTime.fromLocalDateTime(pattern: String = "yyyy-MM-dd HH:mm:ss"): String {
        return this.format(DateTimeFormatter.ofPattern(pattern))
    }

    fun Temporal.toBRTStringDate(pattern: String = "HH:mm:ss dd-MM-yyyy"): String {
    return DateTimeFormatter.ofPattern(pattern).withZone(ZoneId.of("America/Sao_Paulo")).format(this)
}


    fun Instant.getFirstDayOfMonth(): Instant {
        return ZonedDateTime.ofInstant(this, ZoneOffset.UTC)
                .with(TemporalAdjusters.firstDayOfMonth()).withHour(0).withMinute(0).withSecond(0).withNano(0)
                .toInstant()
    }

    fun LocalDate.startOfDay(): LocalDateTime {
        return LocalDateTime.of(this, LocalTime.of(0, 0, 0))
    }

    fun Instant.getLastDayOfMonth(): Instant {
        return ZonedDateTime.ofInstant(this, ZoneOffset.UTC)
                .with(TemporalAdjusters.lastDayOfMonth()).withHour(23).withMinute(59).withSecond(59).withNano(999000)
                .toInstant()
    }

    fun LocalDate.getFirstDayOfMonth(): LocalDate {
        return this.with(TemporalAdjusters.firstDayOfMonth())
    }

    fun LocalDate.getLastDayOfMonth(): LocalDate {
        return this.with(TemporalAdjusters.lastDayOfMonth())
    }

    fun LocalDate.calculateDayDiffFromNow() : Long {
        return ChronoUnit.DAYS.between(this, LocalDate.now(ZoneOffset.UTC))
    }
