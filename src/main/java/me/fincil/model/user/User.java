package me.fincil.model.user;

import me.fincil.model.Model;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Created by HSWook on 2016. 5. 9..
 */
@Entity
@Data
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
}
