package io.pivotal.k8s.user.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Builder
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;

}
