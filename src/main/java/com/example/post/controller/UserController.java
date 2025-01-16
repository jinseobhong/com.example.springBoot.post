package com.example.post.controller;

import com.example.post.exception.UserNotFoundException;
import com.example.post.model.User;
import com.example.post.service.UserService;
import com.example.post.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping(value = "/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService = new UserServiceImpl();

    // TODO : 회원 가입 뷰 구현
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        return "user/create/createUser"; // user/create/createUser.html
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute User user, Model model) {
        try {
            // 서비스에서 저장 로직 실행
            userService.createUser(user);
            return "redirect:create/success"; // 성공 시 회원 목록 페이지로 리다이렉트
        } catch (Exception e) {
            // 실패 시 에러 메시지와 함께 회원가입 페이지로 다시 이동
            model.addAttribute("statusMessage", "회원가입에 실패했습니다. 다시 시도해주세요.");
            return "user/create/createUser"; // user/create/createUser.html로 이동
        }
    }

    @GetMapping("/create/success")
    public String showSuccessUserCreate() {
        return "user/create/successCreateUser";
    }

    @GetMapping("/select/{id}")
    public String showSelectUser(@PathVariable(name = "id") Long id, Model model) {
        // 서비스에서 사용자 조회 (존재하지 않을 경우 예외 던짐)
        User user = userService.getUser(id).orElseThrow(() -> new UserNotFoundException("사용자를 찾을 수 없습니다.", "유효한 ID를 가진 user를 찾을 수 없습니다.", "유효한 ID를 가진 회원을 입력 해주십시오."));
        // 모델에 사용자 정보 추가
        model.addAttribute("user", user);
        return "user/select/selectById"; // user/select/selectById.html
    }

    @GetMapping("/select/all")
    public String showSelectAllUser(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "user/select/selectAll"; // user/select/selectAll.html
    }
}