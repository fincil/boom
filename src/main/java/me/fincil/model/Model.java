package me.fincil.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by HSWook on 2016. 5. 9..
 */
@MappedSuperclass
public abstract class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long uid;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createdAt;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;

    @PrePersist
    public void onCreate() {
        this.createdAt = new Date();
        this.updatedAt= new Date();
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = new Date();
    }
}
