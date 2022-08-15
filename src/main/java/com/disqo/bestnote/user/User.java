package com.disqo.bestnote.user;

import com.disqo.bestnote.note.Note;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class UserEntity {
    @Id
    private String email;
    @NonNull
    private String password;
    private Timestamp createTime;
    private Timestamp lastUpdateTime;
    @OneToMany(mappedBy = "user")
    private Set<Note> notes;

    public UserEntity(String email, @NonNull String password, Timestamp createTime, Timestamp lastUpdateTime) {
        this.email = email;
        this.password = password;
        this.createTime = createTime;
        this.lastUpdateTime = lastUpdateTime;
    }
}
