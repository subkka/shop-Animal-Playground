package com.playground.admin_page.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
@Aspect
@Slf4j
public class AuthAspect {
    // 로그인 상태 인증 pointcut
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)" +
            "&& !execution(* com.playground.admin_page.SampleController.index(..))" +
            "&& args(model)")
    public void authLogin(Model model) {}

    // 로그인 상태 인증 around
    @Around("authLogin(model)")
    public Object aroundAuthLogin(ProceedingJoinPoint joinPoint, Model model) throws Throwable {
        log.info("around start...");
        log.debug("Method: {}", joinPoint.getSignature().getName());
        log.debug("adminAccount: {}", model.getAttribute("adminAccount"));

        if (model.getAttribute("adminAccount") == null) {
            return "redirect:/";
        }

        return joinPoint.proceed();
    }
}
