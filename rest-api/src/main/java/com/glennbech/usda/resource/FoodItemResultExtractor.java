package com.glennbech.usda.resource;

import com.glennbech.usda.model.FoodItem;
import com.glennbech.usda.model.NutrientValue;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: glennbech
 * Date: 12.09.14
 * Time: 21:17
 * To change this template use File | Settings | File Templates.
 */
class FoodItemResultExtractor implements ResultSetExtractor<List<FoodItem>> {

    @Override
    public List<FoodItem> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        HashMap<String, FoodItem> foodItemMap = new HashMap<String, FoodItem>();
        while (resultSet.next()) {
            String ndbNo = resultSet.getString("NDB_NO");
            FoodItem item = foodItemMap.get(ndbNo);
            if (item == null) {
                FoodItemRowMapper rowMapper = new FoodItemRowMapper();
                item = rowMapper.mapRow(resultSet, resultSet.getRow());
                foodItemMap.put(ndbNo, item);
            }

            NutrientValue n = new NutrientValue();
            String nutrientNo = resultSet.getString("NUTR_NO");
            n.setNutrientNo(nutrientNo);
            n.setDescription(resultSet.getString("NUTR_DESC"));
            n.setOrder(resultSet.getString("SR_ORDER"));
            n.setUnits(resultSet.getString("UNITS"));
            n.setValue(resultSet.getFloat("NUTR_VAL"));
            if (item.getNutrients() == null) {
                item.setNutrients(new ArrayList<NutrientValue>());
            }
            item.getNutrients().add(n);
        }
        return new ArrayList<FoodItem>(foodItemMap.values());
    }
}
