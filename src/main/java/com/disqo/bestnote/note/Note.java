package com.disqo.bestnote.note;

import com.disqo.bestnote.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Note {
    private Long id;
    private String title;
    private String note;
    private Timestamp createTime;
    private Timestamp lastUpdateTime;
    private User user;
}
