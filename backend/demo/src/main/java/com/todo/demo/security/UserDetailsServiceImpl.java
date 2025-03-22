package com.todo.demo.security;

import com.todo.demo.domain.user.Users;
import com.todo.demo.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> findUser = userRepository.findUsersByUserName(username);
        if(findUser.isEmpty()){
            throw new UsernameNotFoundException("user can not found!");
        }
        return new UserDetailsImpl(findUser.get());
    }
}
