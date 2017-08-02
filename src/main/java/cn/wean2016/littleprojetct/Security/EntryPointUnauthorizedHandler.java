package cn.wean2016.littleprojetct.Security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 异常处理器
 * 在密码错误，未登录时触发
 */
@Component
public class EntryPointUnauthorizedHandler implements AuthenticationEntryPoint {

  /**
   * 触发操作
   * @param httpServletRequest
   * @param httpServletResponse
   * @param e
   * @throws IOException
   * @throws ServletException
   */
  @Override
  public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
    httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Access Denied");
  }

}
