package cn.wean2016.littleprojetct.domain;

import java.util.Date;

/**
 * @version V1.0.0
 * @Description
 * @Author liuyuequn weanyq@gmail.com
 * @Date 2017/8/2 16:35
 */
public class UserEntity {

    private Long id;
    private String username;
    private String password;
    private Date LastPasswordReset;
    private String authorities;

    public UserEntity() {
    }


    public UserEntity(Long id, String username, String password, Date lastPasswordReset, String authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        LastPasswordReset = lastPasswordReset;
        this.authorities = authorities;
    }

    public Long getId() {
        return id;
    }

    public UserEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public Date getLastPasswordReset() {
        return LastPasswordReset;
    }

    public UserEntity setLastPasswordReset(Date lastPasswordReset) {
        LastPasswordReset = lastPasswordReset;
        return this;
    }

    public String getAuthorities() {
        return authorities;
    }

    public UserEntity setAuthorities(String authorities) {
        this.authorities = authorities;
        return this;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", LastPasswordReset=" + LastPasswordReset +
                ", authorities='" + authorities + '\'' +
                '}';
    }
}
