package me.fincil.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by HSWook on 2016. 5. 9..
 */

@MappedSuperclass
@Data
public abstract class TreeModel<T> extends Model {

    private static final long serialVersionUID = 1L;

    private long level;
    private long sequence;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parent")
    private Set<T> childs;

    @ManyToOne
    @JoinColumn(name = "PARENT_UID")
    private T parent;
}
