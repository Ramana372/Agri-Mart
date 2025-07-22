//package com.example.Service;
//
//import com.example.Model.User;
//import com.example.Repo.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.*;
//import org.springframework.stereotype.Service;
//
//import java.util.Collections;
//
////@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
////
////    @Autowired
////    private UserRepo userRepo;
////
////    @Override
////    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
////        User user = userRepo.findByEmail(email);
////        if (user == null) {
////            throw new UsernameNotFoundException("User not found: " + email);
////        }
////
////        return new org.springframework.security.core.userdetails.User(
////                user.getEmail(),
////                user.getPassword(),
////                Collections.singleton(new SimpleGrantedAuthority("ROLE_" + user.getRole()))
////        );
////    }
//
//}
