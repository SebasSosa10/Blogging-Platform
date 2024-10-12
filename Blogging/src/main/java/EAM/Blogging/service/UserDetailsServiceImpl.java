package EAM.Blogging.service;

import EAM.Blogging.repository.RepositoryUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final RepositoryUser userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return (UserDetails) userRepository.findByUserProfileUserName(username).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
    }
}
