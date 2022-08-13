package com.disqo.bestnote.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Timestamp createTime;
    private Timestamp lastUpdateTime;
}
