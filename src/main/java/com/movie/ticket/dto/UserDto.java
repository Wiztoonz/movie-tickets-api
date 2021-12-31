package com.movie.ticket.dto;

import java.util.List;

public record UserDto(String firstName, String lastName, String email, List<RoleDto> roles) {
}
