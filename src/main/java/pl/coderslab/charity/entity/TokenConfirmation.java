package pl.coderslab.charity.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class TokenConfirmation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String token;

    @Temporal(TemporalType.TIMESTAMP)
    private Date expirationDate;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
