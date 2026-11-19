package com.darkset.AdvanceMappingTypes;

import jakarta.persistence.*;
import org.hibernate.annotations.TimeZoneColumn;
import org.hibernate.annotations.TimeZoneStorage;
import org.hibernate.annotations.TimeZoneStorageType;

import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
//
//@Entity
//public class TemporalValues {
//
//    @Id
//    private int id;
//
//    @Basic
//    private java.sql.Date sqlDate;
//
//    @Basic
//    private java.sql.Time sqlTime;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private java.sql.Timestamp sqlTimestamp;
//
//    @Basic
//    private java.time.LocalDate localDate;
//
//    @Basic
//    private java.time.LocalTime localTime;
//
//    @Basic
//    private java.time.OffsetTime offsetTime;
//
//    @Basic
//    private java.time.Instant instant;
//
//    @Basic
//    private java.time.LocalDateTime localDateTime;
//
//    @Basic
//    private java.time.OffsetDateTime offsetDateTime;
//
//    @Basic
//    private java.time.ZonedDateTime zonedDateTime;
//
//
//    @TimeZoneStorage(TimeZoneStorageType.COLUMN)
//    @TimeZoneColumn(name = "birthday_offset_offset")
//    @Column(name = "birthday_offset")
//    private OffsetDateTime offsetDateTimeColumn;
//
//    @TimeZoneStorage(TimeZoneStorageType.COLUMN)
//    @TimeZoneColumn(name = "birthday_zoned_offset")
//    @Column(name = "birthday_zoned")
//    private ZonedDateTime zonedDateTimeColumn;
//
//}
