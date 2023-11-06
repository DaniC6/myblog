package it.cgmconsulting.myblog.payload.response;

import it.cgmconsulting.myblog.entities.Avatar;
import it.cgmconsulting.myblog.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class UserResponse {

    private int id;
    private String username;
    private String email;
    private LocalDateTime createdAt;
    private Avatar avatar;


    public static UserResponse fromUserDetailsToUserResponse(User user){
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getAvatar()
        );
    }
}
