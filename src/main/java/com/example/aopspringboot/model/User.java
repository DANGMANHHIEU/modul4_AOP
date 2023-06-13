package com.example.aopspringboot.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank()
    @Size(min = 5, max = 45, message = "có độ dài tối thiểu 5, tối đa 45 ký tự")
    private String firstname;
    @NotBlank()
    @Size(min = 5, max = 45, message = "có độ dài tối thiểu 5, tối đa 45 ký tự")
    private String lastName;

    @Min(value = 18, message = "Lớn hơn hoặc bằng 18")
    private int age;

    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
    private String email;

}
