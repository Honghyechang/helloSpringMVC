package kr.ac.hansung.cse.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name="offers")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Size(min = 4, max = 50, message = "name size error")
    private String name;

    @Email(message = "email error")
    @NotEmpty(message = "notempty")
    private String email;

    @Size(min = 4, max = 50, message = "text size error")
    private String text;



}
