package OguzhanBarboros.WebApp.services;

import OguzhanBarboros.WebApp.repostories.AdminRepositories;
import OguzhanBarboros.WebApp.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminServiceImpl implements AdminService {
    private AdminRepositories adminRepositories;

    @Override
    public Admin kayit(Admin admin) {
        return this.adminRepositories.save(admin);
    }

    @Override
    public Admin sil(Admin admin) {
        this.adminRepositories.deleteById(admin.getId());
        return admin;
    }

    @Autowired
    public AdminServiceImpl(AdminRepositories adminRepositories) {
        super();
        this.adminRepositories = adminRepositories;


    }


    @Override
    public List<Admin> getAll() {
        return this.adminRepositories.findAll();
    }
}
