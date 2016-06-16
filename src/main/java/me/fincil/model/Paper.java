package me.fincil.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import me.fincil.model.user.User;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Paper extends Model {

	private String name;
	
	@ManyToOne
	private User owner;
	
	@ManyToMany
	private Set<User> writers;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Set<User> getWriters() {
		return writers;
	}

	public void setWriters(Set<User> writers) {
		this.writers = writers;
	}
}
