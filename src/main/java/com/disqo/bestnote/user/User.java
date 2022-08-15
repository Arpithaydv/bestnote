package com.disqo.bestnote.user;

import com.disqo.bestnote.note.Note;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
//@AllArgsConstructor
@ToString
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "email_id", nullable = false, unique = true)
    private String emailId;
    @Column(name = "password")
    private String password;
    @Column(name = "create_time", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createTime;
    @Column(name = "last_update_time", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp lastUpdateTime;
//    @OneToMany(
//            mappedBy = "emailId",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
//    private Set<Note> notes = new HashSet<>();

    public User(String email, String password, Timestamp createTime, Timestamp lastUpdateTime) {
        this.emailId = email;
        this.password = password;
        this.createTime = createTime;
        this.lastUpdateTime = lastUpdateTime;
    }
}
