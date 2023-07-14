package com.crbs.service;

import com.crbs.bean.Borrow;

import java.util.List;

/**
 * @author 李英
 * @date 2021年3月12日17:57:42
 * @category 借用表的业务逻辑接口
 */
public interface IBorrowService {
    /**
     * @return 查找所有的借用记录
     */
    public List<Borrow> findAll();

    /**
     * 对借用记录进行修改
     *
     * @param borrow 借用记录对象
     * @return 是否更新成功
     */
    public boolean update(Borrow borrow);

    /**
     * 增加借用记录
     *
     * @param borrow 借用记录
     * @return 是否添加成功
     */
    public boolean add(Borrow borrow);

    /**
     * 删除借用记录
     *
     * @param bid 借用记录id
     * @return 是否删除成功
     */
    public boolean delete(int bid);

    /**
     * 根据用户编号查询用户借用信息
     *
     * @param id 用户编号
     * @return 借用记录列表
     */
    public List<Borrow> findByUid(int id);

    /**
     * 根据房间编号查询房间的借用记录
     *
     * @param id 房间编号
     * @return 借用信息列表
     */
    public List<Borrow> findByRid(int id);

    /**
     * 根据教室借用状态查询教室的借用记录
     *
     * @param status 教室借用状态
     * @return 借用信息列表
     */
    public List<Borrow> findBySta(String status);

    /**
     * @param borrow 借用对象
     * @return 是否更新成功
     */
    public boolean updateSta(Borrow borrow);

    /**
     * 通过借用表编号查询借用表信息
     *
     * @param bid 借用表编号
     * @return 借用表对象
     */
    public Borrow findBorrowByBid(int bid);
}
