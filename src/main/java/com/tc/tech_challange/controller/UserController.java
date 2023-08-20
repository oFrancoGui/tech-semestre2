package com.tc.tech_challange.controller;


import com.tc.tech_challange.domain.users.DataRegisterUser;
import com.tc.tech_challange.domain.users.DataUserDetails;
import com.tc.tech_challange.domain.users.User;
import com.tc.tech_challange.domain.users.UserRepository;
import jakarta.validation.Valid;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("api/v2/user")
public class UserController {

    @Autowired
    private UserRepository repository;
    @PostMapping
    public ResponseEntity register(@RequestBody @Valid DataRegisterUser data, UriComponentsBuilder uriBuilder){

        JSONObject response = new JSONObject();
        var user = new User(data);
        repository.save(user);
        var uri = uriBuilder.path("/eletro/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new DataUserDetails(user));
    }


}
