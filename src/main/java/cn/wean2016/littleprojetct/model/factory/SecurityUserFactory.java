package cn.wean2016.littleprojetct.model.factory;

import cn.wean2016.littleprojetct.domain.UserEntity;
import cn.wean2016.littleprojetct.model.security.SecurityUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Collection;

public class SecurityUserFactory {

  public static SecurityUser create(UserEntity user) {
    Collection<? extends GrantedAuthority> authorities;
    try {
      authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(user.getAuthorities());
    } catch (Exception e) {
      authorities = null;
    }
    return new SecurityUser(
      user.getId(),
      user.getUsername(),
      user.getPassword(),
      user.getLastPasswordReset(),
      authorities
    );
  }

}
