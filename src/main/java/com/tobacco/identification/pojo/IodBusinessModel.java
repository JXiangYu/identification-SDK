package com.tobacco.identification.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName IodBusinessModel
 * @Description 业务数据Model
 * @Author JXiangYu
 * @Date 2020/7/15 16:28
 * @Version 1.0
 */
public class IodBusinessModel implements Serializable {

    /**
     * 数据定义handle
     */
    private String metaHandle;

    /**
     * 业务数据handle 后缀
     */
    private String businessHandle;

    /**
     * 管理员handle
     */
    private String adminHandle;

    /**
     * 业务数据列表
     */
    private List<IodBusinessDataWithAuth> iodBusinessDataWithAuthList;

    public String getMetaHandle() {
        return metaHandle;
    }

    public IodBusinessModel setMetaHandle(String metaHandle) {
        this.metaHandle = metaHandle;
        return this;
    }

    public String getBusinessHandle() {
        return businessHandle;
    }

    public IodBusinessModel setBusinessHandle(String businessHandle) {
        this.businessHandle = businessHandle;
        return this;
    }

    public String getAdminHandle() {
        return adminHandle;
    }

    public IodBusinessModel setAdminHandle(String adminHandle) {
        this.adminHandle = adminHandle;
        return this;
    }

    public List<IodBusinessDataWithAuth> getIodBusinessDataWithAuthList() {
        return iodBusinessDataWithAuthList;
    }

    public IodBusinessModel setIodBusinessDataWithAuthList(List<IodBusinessDataWithAuth> iodBusinessDataWithAuthList) {
        this.iodBusinessDataWithAuthList = iodBusinessDataWithAuthList;
        return this;
    }
}
