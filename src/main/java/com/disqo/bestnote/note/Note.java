package com.disqo.bestnote.note;

import com.disqo.bestnote.user.UserEntity;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
@Table
public class Note {
    @Id
    @SequenceGenerator(name="note_sequence", sequenceName = "note_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "note_sequence")
    private Long id;
    private String title;
    private String note;
    private Timestamp createTime;
    private Timestamp lastUpdateTime;


    public Note(String title, String note, Timestamp createTime, Timestamp lastUpdateTime) {
        this.title = title;
        this.note = note;
        this.createTime = createTime;
        this.lastUpdateTime = lastUpdateTime;
    }
}
