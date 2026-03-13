package com.miaoshaproject.contorller;

import com.miaoshaproject.service.ItemService;
import com.miaoshaproject.service.model.ItemModel;
import com.miaoshaproject.service.model.PromoModel;
import org.joda.time.DateTime;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ItemControllerTest {

    @Test
    public void shouldExposeStockAndPromotionSummaryForInspectEndpoint() throws Exception {
        ItemModel itemModel = new ItemModel();
        itemModel.setId(1);
        itemModel.setTitle("Demo item");
        itemModel.setPrice(BigDecimal.valueOf(99.00));
        itemModel.setStock(12);
        itemModel.setDescription("demo");
        itemModel.setSales("5");
        itemModel.setImgUrl("https://example.com/item.png");

        PromoModel promoModel = new PromoModel();
        promoModel.setId(7);
        promoModel.setStatus(2);
        promoModel.setStartDate(DateTime.parse("2026-03-13T10:00:00"));
        promoModel.setPromoItemPrice(BigDecimal.valueOf(79.00));
        itemModel.setPromoModel(promoModel);

        ItemController controller = new ItemController();
        ItemService itemService = new ItemService() {
            @Override
            public ItemModel createItem(ItemModel ignored) {
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
                return false;
            }

            @Override
            public void increaseSales(Integer itemId, Integer amount) {
            }
        };
        ReflectionTestUtils.setField(controller, "itemService", itemService);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(get("/item/inspect").param("id", "1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value("success"))
            .andExpect(jsonPath("$.data.stock").value(12))
            .andExpect(jsonPath("$.data.promoStatus").value(2))
            .andExpect(jsonPath("$.data.hasActivePromo").value(true))
            .andExpect(jsonPath("$.data.title").value("Demo item"));
    }
}
