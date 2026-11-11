package kh.edu.istad.m1b02restfulapi.dto;

import java.util.Collection;
import java.util.UUID;

public record UserRespone(
        UUID id,
        String fullName,
        boolean isActive
) {
}
