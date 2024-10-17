package za.ac.cput.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private long customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String mobileNumber;
    private LocalDate dateOfBirth;
    private String token;

}
