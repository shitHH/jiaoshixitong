package com.crbs.service;

import com.crbs.vo.BorrowVO;

import java.util.List;

/**
 * @author 李英
 * @date 2021年3月15日17:06:47
 * @category borrowVOService 业务逻辑类
 */
public interface IBorrowVOservice {
    /**
     * 查找所有的BorrowOA的对象列表
     * @return borrowOA对象列表
     */
    public List<BorrowVO> findAll();
}
