package com.littlebuddha.backstage;

import com.littlebuddha.backstage.modules.entity.system.Area;
import com.littlebuddha.backstage.modules.entity.system.Operator;
import com.littlebuddha.backstage.modules.mapper.system.AreaMapper;
import com.littlebuddha.backstage.modules.mapper.system.MenuMapper;
import com.littlebuddha.backstage.modules.mapper.system.OperatorMapper;
import com.littlebuddha.backstage.modules.mapper.system.ProvinceMapper;
import com.littlebuddha.backstage.test.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


@SpringBootTest
class BackstageApplicationTests {

    @Autowired
    private Person person;

    @Autowired
    DataSource dataSource;

    @Autowired
    private OperatorMapper operatorMapper;

    @Autowired
    private AreaMapper areaMapper;

    @Autowired
    private ProvinceMapper provinceMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Test
    void contextLoads() {
        System.out.println(person);
    }

    @Test
    void testDB() {
        System.out.println(dataSource.getClass());
        try {
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testOperatorMapper(){
        Operator entity = new Operator();
        entity.setName("admin");
        List<Operator> byName = operatorMapper.findByName(entity);
        for (Operator operator : byName) {
            System.out.println(operator.getName());
        }
    }

    @Test
    public void testAreaMapper(){
        List<Area> all = areaMapper.findAll(new Area());
        for (Area area : all) {
            System.out.println(area.getName());
        }
    }

    /*@Test
    public void testMenuMapper(){
        List<Menu> menus = menuMapper.findAllList(new Menu());
        for (Menu menu : menus) {
            System.out.println(menu.getName());
        }
    }*/
}
