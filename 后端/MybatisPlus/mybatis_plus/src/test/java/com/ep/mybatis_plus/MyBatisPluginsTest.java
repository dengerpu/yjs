package com.ep.mybatis_plus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ep.mybatis_plus.mapper.ProductMapper;
import com.ep.mybatis_plus.mapper.UserMapper;
import com.ep.mybatis_plus.pojo.Product;
import com.ep.mybatis_plus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MyBatisPluginsTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ProductMapper productMapper;

    @Test
    public void test01() {
        Page<User> page = new Page<>(1, 5);
        userMapper.selectPage(page, null);
        System.out.println("数据：" + page.getRecords());
        System.out.println("当前页：" + page.getCurrent());
        System.out.println("每页显示的条数：" + page.getSize());
        System.out.println("总记录数：" + page.getTotal());
        System.out.println("总页数：" + page.getPages());
        System.out.println("是否有上一页：" + page.hasPrevious());
        System.out.println("是否有下一页：" + page.hasNext());
    }

    @Test
    public void testPage() {
        Page<User> page = new Page<>(1, 5);
        userMapper.selectUserByAgeVo(page, 20);
        System.out.println(page.getRecords());
    }

    @Test
    public void testConcurrentUpdate() {
        //1、小李
        Product p1 = productMapper.selectById(1L);
        System.out.println("小李取出的价格：" + p1.getPrice());
        //2、小王
        Product p2 = productMapper.selectById(1L);
        System.out.println("小王取出的价格：" + p2.getPrice());
        //3、小李将价格加了50元，存入了数据库
        p1.setPrice(p1.getPrice() + 50);
        int result1 = productMapper.updateById(p1);
        System.out.println("小李修改结果：" + result1);
        //4、小王将商品减了30元，存入了数据库
        p2.setPrice(p2.getPrice() - 30);
        int result2 = productMapper.updateById(p2);
        if (result2 == 0) {
            // 操作失败
            Product productNew = productMapper.selectById(1L);
            productNew.setPrice(productNew.getPrice() - 30);
            int i = productMapper.updateById(productNew);
        }
        System.out.println("小王修改重试的结果：" + result2);
        //最后的结果
        Product p3 = productMapper.selectById(1L);
        //价格覆盖，最后的结果：70
        System.out.println("最后的结果：" + p3.getPrice());
    }
}
