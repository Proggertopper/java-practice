package com.darkset.AdvanceMappingTypes;

import jakarta.persistence.*;
import org.hibernate.annotations.*;
import org.hibernate.type.descriptor.jdbc.LongVarcharJdbcType;
import org.hibernate.type.descriptor.jdbc.NumericJdbcType;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "customers")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "birth_date")
    @JdbcType(LongVarcharJdbcType.class)
    private LocalDate birthDate;

    @Column(name = "is_active")//columnDefinition = "BIT"
    @JdbcType(NumericJdbcType.class)
    private Boolean active;

    @Column(name = "favourite_color")
    @Enumerated(EnumType.STRING)
    private Color favouriteColor;

    @Column(name = "created_at")
    //@CreationTimestamp
    private Date createdAt;

    @Column(name = "updated_at")
    //@UpdateTimestamp
    private Date updatedAt;

    @PrePersist
    protected void onCreate(){
        createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        updatedAt= new Date();
    }

//    @Transient
//    private int fullNameWithBirthDate;

//    @Formula()
}
