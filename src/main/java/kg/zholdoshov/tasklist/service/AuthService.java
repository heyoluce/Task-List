package kg.zholdoshov.tasklist.service;

import kg.zholdoshov.tasklist.web.dto.auth.JwtRequest;
import kg.zholdoshov.tasklist.web.dto.auth.JwtResponse;

public interface AuthService {

    JwtResponse login(JwtRequest loginRequest);

    JwtResponse refresh(String refreshToken);
}
