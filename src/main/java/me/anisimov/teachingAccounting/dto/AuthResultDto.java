package me.anisimov.teachingAccounting.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AuthResultDto {

    private final String userName;
    private final String role;
}
