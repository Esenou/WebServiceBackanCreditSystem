package com.credit.system.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @CreationTimestamp
    @DateTimeFormat(pattern="dd-MM-yyyy HH:mm")
    @Column(name = "create_date")
    private LocalDateTime createDate;


    @UpdateTimestamp
    @DateTimeFormat(pattern="dd-MM-yyyy HH:mm")
    @Column(name = "update_date")
    private LocalDateTime updateDate = LocalDateTime.now();
}
