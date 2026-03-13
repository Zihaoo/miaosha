package com.miaoshaproject.service.impl;

import com.miaoshaproject.dao.OrderDOMapper;
import com.miaoshaproject.dao.SequenceDOMapper;
import com.miaoshaproject.error.BussinessException;
import com.miaoshaproject.error.EmBusinessError;
import com.miaoshaproject.service.ItemService;
import com.miaoshaproject.service.UserService;
import com.miaoshaproject.service.model.ItemModel;
import com.miaoshaproject.service.model.UserModel;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
public class OrderServiceImplTest {

    private OrderServiceImpl orderService;

    private ItemModel itemModel;

    @Before
    public void setUp() {
        orderService = new OrderServiceImpl();
        itemModel = new ItemModel();
        itemModel.setId(1);
        itemModel.setTitle("Demo item");
        itemModel.setPrice(BigDecimal.TEN);
        itemModel.setStock(20);
        itemModel.setDescription("demo");
        itemModel.setSales("0");
        itemModel.setImgUrl("https://example.com/demo.png");

        ItemService itemService = new ItemService() {
            @Override
            public ItemModel createItem(ItemModel itemModel) {
                return null;
            }

            @Override
            public java.util.List<ItemModel> listItem() {
                return java.util.Collections.emptyList();
            }

            @Override
            public ItemModel getItemById(Integer id) {
                return id.equals(1) ? itemModel : null;
            }

            @Override
            public boolean decreaseStock(Integer itemId, Integer amount) {
                return true;
            }

            @Override
            public void increaseSales(Integer itemId, Integer amount) {
            }
        };
        UserService userService = new UserService() {
            @Override
            public UserModel getUserById(Integer id) {
                return null;
            }

            @Override
            public void register(UserModel userModel) {
            }

            @Override
            public UserModel validateLogin(String telphone, String encrptPassword) {
                return null;
            }
        };

        ReflectionTestUtils.setField(orderService, "itemService", itemService);
        ReflectionTestUtils.setField(orderService, "userService", userService);
        ReflectionTestUtils.setField(orderService, "orderDOMapper", (OrderDOMapper) null);
        ReflectionTestUtils.setField(orderService, "sequenceDOMapper", (SequenceDOMapper) null);
    }

    @Test
    public void shouldRejectMissingUserBeforeTouchingInventory() {
        try {
            orderService.createOrder(99, 1, null, 1);
        } catch (BussinessException ex) {
            assertEquals(EmBusinessError.PARAMETER_VALIDATION_ERROR.getErrCode(), ex.getErrCode());
            assertEquals("用户不存在", ex.getErrMsg());
            return;
        }

        throw new AssertionError("Expected BussinessException");
    }
}
