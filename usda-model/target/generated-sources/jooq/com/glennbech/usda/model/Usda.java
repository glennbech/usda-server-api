/**
 * This class is generated by jOOQ
 */
package com.glennbech.usda.model;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.4.2" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Usda extends org.jooq.impl.SchemaImpl {

	private static final long serialVersionUID = 1277870394;

	/**
	 * The singleton instance of <code>usda</code>
	 */
	public static final Usda USDA = new Usda();

	/**
	 * No further instances allowed
	 */
	private Usda() {
		super("usda");
	}

	@Override
	public final java.util.List<org.jooq.Table<?>> getTables() {
		java.util.List result = new java.util.ArrayList();
		result.addAll(getTables0());
		return result;
	}

	private final java.util.List<org.jooq.Table<?>> getTables0() {
		return java.util.Arrays.<org.jooq.Table<?>>asList(
			com.glennbech.usda.model.tables.DataSrc.DATA_SRC,
			com.glennbech.usda.model.tables.Datsrcln.DATSRCLN,
			com.glennbech.usda.model.tables.DerivCd.DERIV_CD,
			com.glennbech.usda.model.tables.FdGroup.FD_GROUP,
			com.glennbech.usda.model.tables.FoodDes.FOOD_DES,
			com.glennbech.usda.model.tables.Footnote.FOOTNOTE,
			com.glennbech.usda.model.tables.Langdesc.LANGDESC,
			com.glennbech.usda.model.tables.Langual.LANGUAL,
			com.glennbech.usda.model.tables.NutrDef.NUTR_DEF,
			com.glennbech.usda.model.tables.NutData.NUT_DATA,
			com.glennbech.usda.model.tables.SrcCd.SRC_CD,
			com.glennbech.usda.model.tables.VFoodLangual.V_FOOD_LANGUAL,
			com.glennbech.usda.model.tables.VFoodNutrient.V_FOOD_NUTRIENT,
			com.glennbech.usda.model.tables.Weight.WEIGHT);
	}
}
