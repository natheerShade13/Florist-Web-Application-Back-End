package za.ac.cput.factory;

import za.ac.cput.domain.Admin;
import za.ac.cput.util.AdminHelper;

public class AdminFactory {

    public static Admin buildAdmin(String email, String password, String role) {
        if (AdminHelper.isNullOrEmpty(email) ||
                AdminHelper.isNullOrEmpty(password) ||
                AdminHelper.isNullOrEmpty(role)) {
            return null;
        }
        return new Admin.Builder()
                .setEmail(email)
                .setPassword(password)
                .setRole(role)
                .build();
    }
}

