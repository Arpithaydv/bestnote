package com.disqo.bestnote.user;

import lombok.Data;

import java.sql.Timestamp;

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
        if(this.lastUpdateTime != null) user.setLastUpdateTime(this.getLastUpdateTime());
        return user;
    }
}
