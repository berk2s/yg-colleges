package com.yataygecisle.preference.colleges.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(generator = "UUIDGenerator")
    @GenericGenerator(
            name = "UUIDGenerator",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "org.hibernate.type.UUIDCharType")
    @Column(updatable = false, insertable = false)
    private UUID id;

    @CreationTimestamp
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp lastModifiedAt;

    @Version
    private Long version;

}
