package com.bca.cmt.model;

import com.bca.cmt.model.user.Users;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_token")
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "token_id_seq")
    @SequenceGenerator(name = "token_id_seq", sequenceName = "token_id_seq",  allocationSize=1)
    private Long id;

    @Column(length = 1024)  // Burada uzunluğu arttırıyoruz
    private String accessToken;
    private OffsetDateTime accessTokenExpiryDate;

    @Column(length = 1024)  // Burada uzunluğu arttırıyoruz
    private String refreshToken;
    private OffsetDateTime refreshTokenExpiryDate;

    private boolean blacklisted;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Users users;
}
