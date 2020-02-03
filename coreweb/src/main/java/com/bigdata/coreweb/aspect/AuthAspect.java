package com.bigdata.coreweb.aspect;

import com.bigdata.coreweb.model.LoginInfo;
import com.bigdata.coreweb.util.RedisUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * api 接口权限校验
 */
@Component
@Aspect
public class AuthAspect {

    private static final int LIVE_TIME = 3600;

    @Autowired
    private RedisUtil redisUtil;

    @Pointcut(value = "execution(public * com.bigdata.coreweb.controller..*.*(..)) )")
    public void addTokenLifePointCut() {
    }

    @Around("addTokenLifePointCut()")
    public Object addTokenLife(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = this.getToken(request);
        if (token != null && redisUtil.hasKey(token)) {
            LoginInfo loginInfo = (LoginInfo) redisUtil.get(token);
            redisUtil.set(token, loginInfo, LIVE_TIME);
            System.out.println("延迟token 60分钟 ignore");
        }
        return joinPoint.proceed();

    }

    public String getToken(HttpServletRequest request) {
        return request.getHeader("token");
    }

    public String getCode(HttpServletRequest request) {
        return request.getHeader("code");
    }

    public LoginInfo getLoginfo(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = this.getToken(request);
        LoginInfo loginInfo = null;
        if (token != null && redisUtil.hasKey(token)) {
            loginInfo = (LoginInfo) redisUtil.get(token);
        }
        return loginInfo;
    }

    public String getLoginName(){
        String longinName = "";
        LoginInfo loginfo = this.getLoginfo();
        if(loginfo != null){
            longinName = loginfo.getName();
        }
        return longinName;
    }

    public String getLoginUserDistrictCode(){
        String districtCode = "";
        LoginInfo loginfo = this.getLoginfo();
        if(loginfo != null){
            districtCode = loginfo.getDistrictCode();
        }
        return districtCode;
    }

}

