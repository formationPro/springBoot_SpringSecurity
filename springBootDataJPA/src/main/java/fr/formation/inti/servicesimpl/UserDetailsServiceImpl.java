package fr.formation.inti.servicesimpl;
 
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.inti.dao.AppRoleRepository;
import fr.formation.inti.dao.AppUserRepository;
import fr.formation.inti.entities.AppUser;
 
@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
 
    @Autowired
    private AppUserRepository appUserRepository;
 
    @Autowired
    private AppRoleRepository appRoleRepository;
 
    @Override
    public UserDetails loadUserByUsername(String userName) {
        AppUser appUser = this.appUserRepository.findByUserName(userName);
 
        if (appUser == null) {
            return null;
        }
 
 
        // [ROLE_USER, ROLE_ADMIN,..]
        List<String> roleNames = this.appRoleRepository.findAllByUserId(appUser.getUserId());
 
        List<GrantedAuthority> grantList = new ArrayList<>();
        if (roleNames != null) {
            for (String role : roleNames) {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }
        } 
        return  new User(appUser.getUserName(),appUser.getEncrytedPassword(), grantList);
    }
 
}