package cn.wean2016.littleprojetct.service.serviceImpl;

import cn.wean2016.littleprojetct.dao.UserDao;
import cn.wean2016.littleprojetct.domain.UserEntity;
import cn.wean2016.littleprojetct.model.factory.SecurityUserFactory;
import cn.wean2016.littleprojetct.model.security.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @version V1.0.0
 * @Description
 * @Author liuyuequn weanyq@gmail.com
 * @Date 2017/8/2 16:43
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userEntity = userDao.findByUserName(username);
        Collection<? extends GrantedAuthority> authorities;

        if (userEntity == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
        return SecurityUserFactory.create(userEntity);
        }
    }
}
