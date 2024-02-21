package com.example.md4casestudyfastfood.model;

//import com.example.test.domain.enumration.EStatusDelete;
import jakarta.persistence.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseEntity implements ApplicationContextAware {
    protected static ApplicationContext context;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        context = applicationContext;
    }
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column( nullable = false)
    private LocalDateTime updatedAt;
//    @Enumerated(value = EnumType.STRING)
//    private EStatusDelete deleted = EStatusDelete.NON_DELETED;

    private String deletedBy;

    private LocalDateTime deletedAt;

    private String createdBy;

    private String updatedBy;

//    @PrePersist
//    protected void onCreate() {
//        createdAt = LocalDateTime.now();
//        updatedAt = LocalDateTime.now();
//        createdBy = getCurrentUsername();
//        updatedBy = getCurrentUsername();
//    }

//    @PreUpdate
//    protected void onUpdate() {
//        updatedAt = LocalDateTime.now();
//        updatedBy = getCurrentUsername();
//    }
//    @PreRemove
//    protected void onRemove() {
//        deletedAt = LocalDateTime.now();
//        deletedBy = getCurrentUsername();
//    }



//    public String getCurrentUsername() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication != null) {
//            return authentication.getName();
//        }
//        return null;
//    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

//    public EStatusDelete getDeleted() {
//        return deleted;
//    }
//
//    public void setDeleted(EStatusDelete deleted) {
//        this.deleted = deleted;
//    }

    public String getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}