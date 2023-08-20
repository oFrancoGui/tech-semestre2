package com.tc.tech_challange.domain.users;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import java.util.UUID;

@Table(name="table_User")
@Entity(name="User")
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name="uuid")
    private UUID id;
    @Column(name="user_email")
    private String user_email;
    @Column(name="user_password")
    private String user_password;

    public User(DataRegisterUser data){
    this.user_email = data.email();
    this.user_password = data.password();
    }
}
