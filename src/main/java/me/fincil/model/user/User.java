package me.fincil.model.user;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonIgnore;

import me.fincil.model.Book;
import me.fincil.model.Model;
import me.fincil.model.Room;

/**
 * Created by HSWook on 2016. 5. 9..
 */
@Entity
public class User extends Model {
    private String email;
    private String name;
    private String pw;
    private String mobile;
    private String smsYn;
    private String gender;
    private long age;
    private String location;
    private long preferPrice;
    private String preferClassType;
    private String mailAuthYn;
    private String mailAuthKey;
    private String facebookToken;
    private String naverToken;
    private String kakaoToken;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Room> rooms;
    
    @PrePersist
    public void onCreate() {
        Room room = new Room();
        Book book = new Book();
        room.getBooks().add(book);
        rooms.add(room);
        
        super.onCreate();
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSmsYn() {
		return smsYn;
	}

	public void setSmsYn(String smsYn) {
		this.smsYn = smsYn;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getAge() {
		return age;
	}

	public void setAge(long age) {
		this.age = age;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public long getPreferPrice() {
		return preferPrice;
	}

	public void setPreferPrice(long preferPrice) {
		this.preferPrice = preferPrice;
	}

	public String getPreferClassType() {
		return preferClassType;
	}

	public void setPreferClassType(String preferClassType) {
		this.preferClassType = preferClassType;
	}

	public String getMailAuthYn() {
		return mailAuthYn;
	}

	public void setMailAuthYn(String mailAuthYn) {
		this.mailAuthYn = mailAuthYn;
	}

	public String getMailAuthKey() {
		return mailAuthKey;
	}

	public void setMailAuthKey(String mailAuthKey) {
		this.mailAuthKey = mailAuthKey;
	}

	public String getFacebookToken() {
		return facebookToken;
	}

	public void setFacebookToken(String facebookToken) {
		this.facebookToken = facebookToken;
	}

	public String getNaverToken() {
		return naverToken;
	}

	public void setNaverToken(String naverToken) {
		this.naverToken = naverToken;
	}

	public String getKakaoToken() {
		return kakaoToken;
	}

	public void setKakaoToken(String kakaoToken) {
		this.kakaoToken = kakaoToken;
	}

	public Set<Room> getRooms() {
		return rooms;
	}

	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}
}
