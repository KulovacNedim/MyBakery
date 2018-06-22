package dao;

import model.Role;
import model.User;

public interface RoleDAO {

    public Role getRoleById(int id);

    boolean addRole(Role role);

    boolean updateRole(Role role);
}
