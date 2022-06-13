package com.aaldama.rentacar.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class ResetToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = false)
    private String token;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    @Column(name = "expiry_date")
    private LocalDateTime expiryDate;

    @Column(name = "attempts")
    private Integer count;

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setExpiryDaten(int minutes) {
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime exp = today.plusMinutes(minutes);
        this.expiryDate = exp;
    }

    public boolean isExpiryDate() {
        return LocalDateTime.now().isAfter(this.expiryDate);
    }
}
