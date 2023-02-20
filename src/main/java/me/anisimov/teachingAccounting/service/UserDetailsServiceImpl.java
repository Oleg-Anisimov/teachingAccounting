package me.anisimov.teachingAccounting.service;

import lombok.extern.slf4j.Slf4j;
import me.anisimov.teachingAccounting.domain.User;
import me.anisimov.teachingAccounting.dto.UserDto;
import me.anisimov.teachingAccounting.repository.RoleRepository;
import me.anisimov.teachingAccounting.repository.UserRepository;
import me.anisimov.teachingAccounting.util.SecurityUtils;
import me.anisimov.teachingAccounting.util.annotation.UserDetailsMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDetailsMapper userDetailsMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;

    public UserDto createUser(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setLogin(userDto.getLogin());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRole(roleRepository.getReferenceById(userDto.getRoleId()));
        userRepository.save(user);
        return mapper.map(user, UserDto.class);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public void updateUser(UserDto userDto)
    {

        User user = userRepository.getReferenceById(userDto.getId());
        user.setLogin(userDto.getLogin());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRole(roleRepository.getReferenceById(userDto.getRoleId()));
        userRepository.save(user);

    }

    public User getById(Long id) {
        return userRepository.getReferenceById(id);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User getCurrentUser(){
        String username = SecurityUtils.getCurrentUsername();
        return userRepository.findUserByLogin(username);
    }

    public Boolean isLoggedIn(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.isAuthenticated();
    }
    public User findByLogin(String login){
        return userRepository.findUserByLogin(login);
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<User> user = Optional.ofNullable(findByLogin(login));
        UserDetails userDetails = userDetailsMapper.convertToUserDetails(user.orElseThrow(() ->
                new  UsernameNotFoundException("Wrong user or password")));
        return userDetails;
    }
}
