package com.eazybytes.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
@MappedSuperclass // Indicate JPA framework that this class will act as a super class for all entities where this class
                  // will be extended
@EntityListeners(AuditingEntityListener.class)
@Getter // Generate Getter
@Setter // Generate Setter
@ToString
public class BaseEntity {
    // In the database table the column name is created_at which is being shown as createdAt
    // In this way there is no need for JPA to tell which column is mapped to which field
    @CreatedDate
    @Column(updatable = false) // Won't update
    private LocalDateTime createdAt;
    @CreatedBy
    @Column(updatable = false)
    private String createdBy;
    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime updatedAt;
    @LastModifiedBy
    @Column(insertable = false)
    private String updatedBy;
}
