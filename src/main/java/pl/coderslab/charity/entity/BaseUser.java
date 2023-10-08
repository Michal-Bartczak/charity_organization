package pl.coderslab.charity.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseUser {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "entity_seq")
    @TableGenerator(
            name = "entity_seq",
            table = "SEQUENCE_TABLE",
            pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_VALUE",
            pkColumnValue = "BASE_USER_SEQ",
            allocationSize = 1
    )
    private Long id;
    @Column(unique = true)
    @Size(min = 5,max = 20,message = "Nazwa użytkownika musi zawierać od 5 do 20 znaków")
    private String username;
    @Column(unique = true)
    private String email;

    private String password;
}
