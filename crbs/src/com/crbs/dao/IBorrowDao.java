package com.crbs.dao;

import com.crbs.bean.Borrow;

import java.util.List;

/**
 * @author 李英
 * @date 2021年3月12日14:40:37
 * @category 借用表的数据实现接口
 * @vision 1.0
 */
public interface IBorrowDao {
    /**
     * @return 查找所有的借用记录
     */
    public List<Borrow> findAll();

    /**
     * 对借用记录进行修改
     * @param borrow 借用记录对象
     * @return 受影响的行数
     */
    public int update(Borrow borrow);

    /**
     * 增加借用记录
     * @param borrow 借用记录
     * @return 受影响的行数
     */
    public int add(Borrow borrow);

    /**
     * 删除借用记录
     * @param bid 借用记录id
     * @return 受影响的行数
     */
    public int delete(int bid);

    /**
     * 根据用户编号查询用户借用信息
     * @param id 用户编号
     * @return 借用记录列表
     */
    public List<Borrow> findByUid(int id);

    /**
     * 根据房间编号查询房间的借用记录
     * @param id 房间编号
     * @return 借用信息列表
     */
    public List<Borrow> findByRid(int id);

    /**
     * 根据教室借用状态查询教室的借用记录
     * @param status 教室借用状态
     * @return 借用信息列表
     */
    public List<Borrow> findBySta(String status);

    /**
     * 更改教室的借用状态
     * @param borrow 教室对象
     * @return 受影响的行数
     */
    public int updateSta(Borrow borrow);

    /**
     * 通过借用表编号查询借用表信息
     * @param bid 借用表编号
     * @return 借用表对象
     */
    public Borrow findBorrowByBid(int bid);

    /**
     * 多表联查
     * @return 借用列表
     */
    public List<Borrow> findBorrowByUR();
}
