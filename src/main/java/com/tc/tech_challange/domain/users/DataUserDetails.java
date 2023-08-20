package com.tc.tech_challange.domain.users;

public record DataUserDetails (String email) {
    public DataUserDetails(User user) {
        this(user.getUser_email());
    }


}
