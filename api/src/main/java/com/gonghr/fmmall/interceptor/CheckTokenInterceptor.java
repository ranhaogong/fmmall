package com.gonghr.fmmall.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gonghr.fmmall.common.result.Result;
import com.gonghr.fmmall.common.result.ResultCodeEnum;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class CheckTokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //放⾏options请求
        String method = request.getMethod();
        if("OPTIONS".equalsIgnoreCase(method)){
            return true;
        }
        String token = request.getHeader("token");
        if (token == null) {
            return false;
        } else {
            try {
                //验证token
                JwtParser parser = Jwts.parser();
                //解析token的SigningKey必须和⽣成token时设置密码⼀致
                parser.setSigningKey("gonghr");
                //如果token正确（密码正确，有效期内）则正常执⾏，否则抛出异常
                Jws<Claims> claimsJws = parser.parseClaimsJws(token);
                return true;
            } catch (ExpiredJwtException e) {
                Result result = new Result(ResultCodeEnum.LOGIN_FAILURE_EXPIRATION, null);
                doResponse(response, result);
            } catch (UnsupportedJwtException e) {
                Result resultVO = new Result(ResultCodeEnum.LOGIN_FAILURE_ILLEGAL_TOKEN, null);
                doResponse(response, resultVO);
            } catch (Exception e) {
                Result resultVO = new Result(ResultCodeEnum.NOT_LOGIN, null);
                doResponse(response, resultVO);
            }
        }
        return false;
    }

    private void doResponse(HttpServletResponse response, Result result) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String s = new ObjectMapper().writeValueAsString(result);
        out.print(s);
        out.flush();
        out.close();
    }
}
