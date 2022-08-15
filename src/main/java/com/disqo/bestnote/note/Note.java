package com.disqo.bestnote.note;

import com.disqo.bestnote.user.User;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
@Table(name = "note")
public class Note {
    @Id
    @Column(name = "title",columnDefinition="text", length=50)
    private String title;
    @Column(name = "notes",columnDefinition="text", length=1000)
    private String notes;
    @Column(name = "create_time", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createTime;
    @Column(name = "last_update_time", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp lastUpdateTime;
//    @ManyToOne
//    @JoinColumn(name="email_id", nullable = false)
    private String emailId;


    public Note(String title, String notes, Timestamp createTime, Timestamp lastUpdateTime) {
        this.title = title;
        this.notes = notes;
        this.createTime = createTime;
        this.lastUpdateTime = lastUpdateTime;
    }
}
