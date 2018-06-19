package dto;

/**
 * Access Flag
 *
 * This is dto object that manages access for user roles which is referenced by roleId;
 *
 * 
 */
public class AccessFlag {

    private int accessFlagId;
    private String accessFlag;

    public AccessFlag {

    }

    public int getAccessFlagId() {
        return accessFlagId;
    }

    public void setAccessFlagId(int accessFlagId) {
        this.accessFlagId = accessFlagId;
    }

    public String getAccessFlag() {
        return accessFlag;
    }

    public void setAccessFlag(String accessFlag) {
        this.accessFlag = accessFlag;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "AccessFlag{" +
                "accessFlagId=" + accessFlagId +
                ", accessFlag='" + accessFlag + '\'' +
                '}';
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        AccessFlag that = (AccessFlag) object;
        return accessFlagId == that.accessFlagId &&
                java.util.Objects.equals(accessFlag, that.accessFlag);
    }

    public int hashCode() {

        return Objects.hash(super.hashCode(), accessFlagId, accessFlag);
    }
}