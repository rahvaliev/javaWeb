package bg.softuni.bulgarianrowingcommunity.model.entity;

import bg.softuni.bulgarianrowingcommunity.model.enums.RoleEnums;
import jakarta.persistence.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

@Entity
@Table(name = "baseUsers")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BaseUserEntity extends BaseEntity {
    private String username;
    private String fullName;
    private String email;
    private String password;
    private String profilePicUrl;

    private Set<RoleEntity>roles;

    @OneToMany
    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public BaseUserEntity setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
        return this;
    }



    public String getUsername() {
        return username;
    }

    public BaseUserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public BaseUserEntity setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public BaseUserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public BaseUserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getProfilePicUrl() {
        return profilePicUrl;
    }

    public BaseUserEntity setProfilePicUrl(String profilePicUrl) {
        this.profilePicUrl = profilePicUrl;
        return this;
    }
}
