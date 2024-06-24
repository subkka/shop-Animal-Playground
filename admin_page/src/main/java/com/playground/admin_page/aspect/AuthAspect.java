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
    @Pointcut("execution(* com.playground.admin_page.login.controller.LoginController.adminOnly(..)) && args(model)")
    public void membersOnlyPointcut(Model model) {}


    @Around("membersOnlyPointcut(model)")
    public Object aroundMembersOnly(ProceedingJoinPoint joinPoint, Model model) throws Throwable {
        log.debug("Method: {}", joinPoint.getSignature().getName());
        log.debug("Model attribute 'name': {}", model.getAttribute("name"));

        // joinPoint 실행전 삽입코드
        if (model.getAttribute("name") == null) {
            return "redirect:/"; // 리턴 값을 변경하여 리다이렉트 처리
        }

        // 원래 메소드를 실행하고 결과를 반환
        return joinPoint.proceed();
    }
}