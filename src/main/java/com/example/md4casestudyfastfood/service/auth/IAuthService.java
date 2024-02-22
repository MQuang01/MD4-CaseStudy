package com.example.md4casestudyfastfood.service.auth;

import com.example.md4casestudyfastfood.model.dto.req.RegisterReqDto;

public interface IAuthService {

    void save(RegisterReqDto registerReqDto);
}
