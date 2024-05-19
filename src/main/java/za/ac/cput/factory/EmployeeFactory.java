package za.ac.cput.factory;

import za.ac.cput.domain.Employee;
import za.ac.cput.domain.Message;
import za.ac.cput.utility.EmployeeHelper;

import java.util.List;

public class EmployeeFactory {

    public static Employee buildEmployee(long employeeId, String name, String email, String address, String phone, String role, List<Message> messages) {
        if (EmployeeHelper.isNullOrEmpty(name) || EmployeeHelper.isNullOrEmpty(email) || EmployeeHelper.isNullOrEmpty(address)
                || EmployeeHelper.isNullOrEmpty(phone) || EmployeeHelper.isNullOrEmpty(role)) {
            return null;
        }

        return new Employee.Builder()
                .setEmployeeId(employeeId)
                .setName(name)
                .setEmail(email)
                .setAddress(address)
                .setPhone(phone)
                .setRole(role)
                .setMessages(messages)
                .build();
    }
/*
    public static Employee buildEmployee(String name, String email, String address, String phone, String role, List<Message> messages) {
        if (Helper.isNullOrEmpty(name) || Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(address)
                || Helper.isNullOrEmpty(phone) || Helper.isNullOrEmpty(role)) {
            return null;
        }

        long employeeId = Helper.generateID();

        return new Employee.Builder()
                .setEmployeeId(employeeId)
                .setName(name)
                .setEmail(email)
                .setAddress(address)
                .setPhone(phone)
                .setRole(role)
                .setMessages(messages)
                .build();
    }
    */
}
