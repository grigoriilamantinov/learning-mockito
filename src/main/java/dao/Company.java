package dao;

import lombok.*;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Company {
    private int id;
    private String companyName;
    private List<User> employees;
}
