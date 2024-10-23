package com.explicit.customer.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @SequenceGenerator(
            name = "cutomer_id_sequence",
            sequenceName = "cutomer_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cutomer_id_sequence"
    )
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
}
