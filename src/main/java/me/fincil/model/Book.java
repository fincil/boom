package me.fincil.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import me.fincil.model.type.BookType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Book extends Model {

	private String name;
	private BookType type;
	
	@OneToMany
	private Set<Paper> papers;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BookType getType() {
		return type;
	}

	public void setType(BookType type) {
		this.type = type;
	}

	public Set<Paper> getPapers() {
		return papers;
	}

	public void setPapers(Set<Paper> papers) {
		this.papers = papers;
	}
}
