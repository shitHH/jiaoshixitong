package com.crbs.dao;

import com.crbs.vo.BorrowVO;

import java.util.List;

/**
 * @author 李英
 * @date 2021年3月15日17:08:04
 * @category BorrowDao 层
 */
public interface IBorrowVODao {
    /**
     * 查找所有的BorrowOA的对象列表
     * @return borrowOA对象列表
     */
  public   List<BorrowVO> findAll();
}
