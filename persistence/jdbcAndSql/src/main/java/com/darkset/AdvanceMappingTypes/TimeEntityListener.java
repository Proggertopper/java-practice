package com.darkset.AdvanceMappingTypes;


import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
//
//public class TimeEntityListener {
//
//    @PrePersist
//    public void onPersist(Object entity) {
//        if (entity instanceof BaseEntity baseEntity) {
//            baseEntity.createdOn = now();
//            System.out.println(">>> [Listener] Установлено createdOn: " + baseEntity.createdOn);
//        }
//    }
//
//    @PreUpdate
//    public void onUpdate(Object entity) {
//        if (entity instanceof BaseEntity baseEntity) {
//            baseEntity.updatedOn = now();
//            System.out.println(">>> [Listener] Установлено updatedOn: " + baseEntity.updatedOn);
//        }
//    }
//
//    private Timestamp now() {
//        return Timestamp.from(LocalDateTime.now().toInstant(ZoneOffset.UTC));
//    }
//}
