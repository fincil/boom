package me.fincil.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

import lombok.Data;
import me.fincil.model.user.User;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
public class Paper extends Model {

	private String name;
	
	@ManyToMany
	private Set<User> users;
}
