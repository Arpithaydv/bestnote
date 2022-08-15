package com.disqo.bestnote.note;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
public class NoteDTO {
    private String title;
    private String notes;
    private Timestamp createTime;
    private Timestamp lastUpdateTime;
    private String emailId;


    public Note toEntity() {
        Note note = new Note();
        if(this.title != null) note.setTitle(this.getTitle());
        if(this.notes != null) note.setNotes(this.getNotes());
        if(this.createTime != null) note.setCreateTime(this.getCreateTime());
        else note.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
        if(this.lastUpdateTime != null) note.setLastUpdateTime(this.getLastUpdateTime());
        else note.setLastUpdateTime(Timestamp.valueOf(LocalDateTime.now()));
        if(this.getEmailId() != null) note.setEmailId(this.getEmailId());
        return note;
    }
}
