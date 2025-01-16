package com.example.post.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    // UserNotFoundException 처리
    @ExceptionHandler(UserNotFoundException.class)
    public String handleUserNotFoundException(UserNotFoundException ex, Model model) {
        // 예외 페이지의 타이틀 제목을 모델에 추가
        model.addAttribute("errorTitle", ex.getTitle());
        // 예외 페이지의 에러 메세지를 모델에 추가
        model.addAttribute("errorMessage", ex.getMessage());
        // 예외 페이지의 에러 메세지를 모델에 추가
        model.addAttribute("notificationMessage", ex.getNotificationMessage());
        // 사용자 찾을 수 없는 에러 페이지로 리턴
        return "error/userNotFound"; // resources/templates/error/userNotFound.html로 이동
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgumentException(IllegalArgumentException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "error/errror"; // 위 HTML 파일의 경로
    }
}
