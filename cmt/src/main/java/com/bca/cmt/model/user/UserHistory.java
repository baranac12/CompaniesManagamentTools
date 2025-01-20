package com.bca.cmt.model.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_user_history")
public class UserHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "user_history_id_seq")
    @SequenceGenerator(name = "user_history_id_seq", sequenceName = "user_history_id_seq", allocationSize=1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private Boolean isActive;
    private String token;
    private LocalDateTime loginDate ;
    private Date logoutDate;
}
