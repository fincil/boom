package me.fincil.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

import me.fincil.model.type.RoomType;
import me.fincil.model.user.User;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Room extends Model {

	private String name;
	private RoomType type;
	
	@ManyToMany
	private Set<Book> books;
	@ManyToMany
	private Set<User> users;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public RoomType getType() {
		return type;
	}
	public void setType(RoomType type) {
		this.type = type;
	}
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
}
