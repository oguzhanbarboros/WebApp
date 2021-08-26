package OguzhanBarboros.WebApp.services;

import OguzhanBarboros.WebApp.model.Admin;

import java.util.List;

public interface AdminService {
    List<Admin> getAll();
    Admin kayit(Admin admin);
    Admin sil(Admin admin);
}
