package co.edu.unisabana.usuario.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String name;
    private String lastName;
    private int age;
    private boolean active;
    private boolean vip;
}
