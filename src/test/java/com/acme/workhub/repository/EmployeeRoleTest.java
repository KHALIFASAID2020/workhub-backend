package com.acme.workhub.repository;

import com.acme.workhub.domain.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmployeeRoleTest {
    @Test
    void defaultActiveIsTrue() {
        var e = Employee.builder().username("u").email("u@x").passwordHash("x").role(Employee.Role.USER).build();
        Assertions.assertTrue(!e.isActive());
    }
}
