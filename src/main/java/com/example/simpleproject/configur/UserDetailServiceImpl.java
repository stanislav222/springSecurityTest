package com.example.simpleproject.configur;

import com.example.simpleproject.dao.UserRepo;
import com.example.simpleproject.model.UsersTwo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsServiceImpl")
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepo userRepo;

    @Autowired
    public UserDetailServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UsersTwo usersTwo = userRepo.findByEmail(email).orElseThrow(()->
                new UsernameNotFoundException("User dont found exist"));
        return SecurityUser.fromUser(usersTwo);
    }
}
