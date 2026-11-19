package com.darkset.AdvanceMappingTypes;

import jakarta.persistence.*;
import org.hibernate.annotations.*;
import org.hibernate.type.SqlTypes;
import org.hibernate.type.descriptor.jdbc.LongVarcharJdbcType;
import org.hibernate.type.descriptor.jdbc.NumericJdbcType;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Map;

@Entity
@Table(name = "customers")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "birth_date")
//    @JdbcType(LongVarcharJdbcType.class)
    @Convert(converter = LocalDateStringConverter.class)
    private LocalDate birthDate;

    @Column(name = "is_active")//columnDefinition = "BIT"
//    @JdbcType(NumericJdbcType.class)
    private Boolean active;

    @Column(name = "favourite_color")
    @Enumerated(EnumType.STRING)
    private Color favouriteColor;

    @Column(name = "created_at")
//    @CreationTimestamp
    @TimeZoneColumn(name = "created_at_tz")
    @TimeZoneStorage(TimeZoneStorageType.COLUMN)
    private ZonedDateTime createdAt;

    @Column(name = "updated_at")
//    @UpdateTimestamp
    @TimeZoneColumn(name = "updated_at_tz")
    @TimeZoneStorage(TimeZoneStorageType.COLUMN)
    private ZonedDateTime updatedAt;

    @PrePersist
    protected void onCreate(){
        createdAt = ZonedDateTime.now();
    }

    @PreUpdate
    protected void onUpdate(){
        updatedAt= ZonedDateTime.now();
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Lob
    @Column(name = "photo" , columnDefinition = "LONGBLOB")
    private byte[] photo;

//    @JdbcTypeCode(SqlTypes.SQLXML)
//    @JdbcTypeCode(SqlTypes.JSON)
//    private Map<String , String> properties;

//    @Transient
//    private int fullNameWithBirthDate;

//    @Formula()
}
