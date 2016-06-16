package me.fincil.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by HSWook on 2016. 5. 9..
 */

@MappedSuperclass
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

	public long getLevel() {
		return level;
	}

	public void setLevel(long level) {
		this.level = level;
	}

	public long getSequence() {
		return sequence;
	}

	public void setSequence(long sequence) {
		this.sequence = sequence;
	}

	public Set<T> getChilds() {
		return childs;
	}

	public void setChilds(Set<T> childs) {
		this.childs = childs;
	}

	public T getParent() {
		return parent;
	}

	public void setParent(T parent) {
		this.parent = parent;
	}
}
