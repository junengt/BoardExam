package click.boardexam.service;

import click.boardexam.domain.User;
import click.boardexam.exception.UidNotFoundException;
import click.boardexam.repository.UserRepository;
import click.boardexam.security.AuthUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String uid) throws UsernameNotFoundException {

        User findUser = userRepository.findByUid(uid).orElseThrow(() -> new UidNotFoundException("UID를 찾을 수 없습니다."));
        if(findUser != null) {
            AuthUser authUser = makeAuthUser(findUser);
            return authUser;
        } else {
            User user = new User();
            user.newUser(uid);
            userRepository.save(user);
            AuthUser authUser = makeAuthUser(user);
            return authUser;
        }
    }

    private AuthUser makeAuthUser(User user) {
        AuthUser authUser = new AuthUser();
        authUser.setUid(user.getUid());
        return authUser;
    }
}
