package com.tc.tech_challange.domain.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;

public interface UserRepository extends JpaRepository<User, String> {
    User getReferenceById(PathVariable id);

}
