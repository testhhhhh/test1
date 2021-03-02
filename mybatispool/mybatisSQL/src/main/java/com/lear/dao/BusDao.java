package com.lear.dao;

import com.lear.domain.Bus;
import com.lear.domain.User;

import java.util.List;

public interface BusDao {
    /**
     * 查询所有操作
     * @return
     */
    List<Bus> findAll();

    /**
     * 保存
     */
    void saveBus(Bus bus);

    /**
     * 更新
     * @param bus
     */
    void updateBus(Bus bus);

    /**
     * 根据id删除
     * @param busId
     */
    void deleteBus(Integer busId);

    /**
     * 根据id查询信息
     * @param busId
     * @return
     */
    Bus findById(Integer busId);

    /**
     * 根据名字模糊查询
     * @param type
     * @return
     */
    List<Bus> findByType(String type);

}
