package dao;

import dto.AccessFlag;

public interface AccessFlagDAO {

    public AccessFlag getAccessFlagById(int id);

    boolean addAccessFlag(AccessFlag accessFlag);

    boolean updateAccessFlag(AccessFlag accessFlag);
}
