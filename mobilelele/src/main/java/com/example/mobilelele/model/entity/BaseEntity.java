package com.example.mobilelele.model.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.SelectBeforeUpdate;

import java.time.Instant;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)

    private LocalDateTime created;
    private LocalDateTime modified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public LocalDateTime getCreated() {
        return created;
    }

    public BaseEntity setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public BaseEntity setModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }

    @PrePersist
    public void beforeCreate(){
        this.created=LocalDateTime.now();
    }

    @PreUpdate
    public void beforeUpdate() {
        this.modified=LocalDateTime.now();
    }
}
