package com.gnuvil.todo_list.service;

import com.gnuvil.todo_list.domain.LoginRequest;
import com.gnuvil.todo_list.domain.LoginResponse;
import com.gnuvil.todo_list.domain.User;
import com.gnuvil.todo_list.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long join(User user) { //회원가입
        validateDuplicateEmail(user.getEmail());
        userRepository.save(user);
        return user.getId();
    }

    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 이메일입니다"));

        if (!user.getPasswd().equals(request.getPasswd())){
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        return new LoginResponse(
                user.getId(),
                user.getEmail(),
                user.getName(),
                "로그인 완료!"
        );
    }

    public User findOne(Long id) {
        User findUser = userRepository.findById(id);
        return findUser;
    }

    public Optional<User> findByEmail(String email) {
        Optional<User> findUser = userRepository.findByEmail(email);
        return findUser;
    }
    public List<User> findAll(){
        return userRepository.findAll();
    }


    private void validateDuplicateEmail(String email) {
        userRepository.findByEmail(email)
                .ifPresent( m ->{
                    throw new IllegalStateException("이미 존재하는 이메일 입니다");
                });
    }
}
