package com.disqo.bestnote.user;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

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
}
