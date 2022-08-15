package com.disqo.bestnote.user;

import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
public class UserDTO {
    private String emailId;
    private String password;
    private Timestamp createTime;
    private Timestamp lastUpdateTime;

    public User toEntity() {
        User user = new User();
        if(this.emailId != null) user.setEmailId(this.emailId);
        if(this.password != null) user.setPassword(this.password);
        if(this.createTime != null) user.setCreateTime(this.getCreateTime());
        else user.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
        if(this.lastUpdateTime != null) user.setLastUpdateTime(this.getLastUpdateTime());
        else user.setLastUpdateTime(Timestamp.valueOf(LocalDateTime.now()));
        return user;
    }
}
