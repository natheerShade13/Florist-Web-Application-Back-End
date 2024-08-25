package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Admin;
import za.ac.cput.repository.AdminRepository;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService implements IService<Admin, Long> {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public Admin create(Admin admin) {
        Optional<Admin> existingAdmin = adminRepository.findByEmail(admin.getEmail());
        if (existingAdmin.isPresent()) {
            throw new IllegalStateException("Admin with email " + admin.getEmail() + " already exists");
        }
        return adminRepository.save(admin);
    }

    public Optional<Admin> getAdminByEmail(String email) {
        return adminRepository.findByEmail(email);
    }

    @Override
    public Admin read(Long id) {
        return adminRepository.findById(id).orElseThrow(() -> new IllegalStateException("Admin with Id " + id + " does not exist"));
    }

    @Override
    public Admin update(Admin admin) {
        if (adminRepository.existsById(admin.getAdminId())) {
            return adminRepository.save(admin);
        } else {
            throw new IllegalStateException("Admin with Id " + admin.getAdminId() + " does not exist");
        }
    }

    @Override
    public boolean delete(Long id) {
        if (adminRepository.existsById(id)) {
            adminRepository.deleteById(id);
            return true;
        } else {
            throw new IllegalStateException("Admin with Id " + id + " does not exist");
        }
    }

    @Override
    public List<Admin> getAll() {
        return adminRepository.findAll();
    }

    public boolean verifyLogin(String email, String password) {
        Optional<Admin> admin = adminRepository.findByEmail(email);
        return admin.isPresent() && admin.get().getPassword().equals(password);
    }
}
