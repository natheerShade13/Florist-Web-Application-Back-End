package za.ac.cput.factory;

import za.ac.cput.domain.Promotion;
import za.ac.cput.utility.PromotionHelper;

import java.util.Date;

public class PromotionFactory {
    public static Promotion buildPromotions(long promotionsId, String name, String description,
                                            Date startDate, Date endDate, String discountType,
                                            double discountAmount){

        if(promotionsId < 0 || PromotionHelper.isNullOrEmpty(name) || PromotionHelper.isNullOrEmpty(description) ||
                PromotionHelper.isNull(startDate) || PromotionHelper.isNull(endDate) || PromotionHelper.isNullOrEmpty(discountType) ||
                PromotionHelper.isNegative(discountAmount))
            return null;

        return new Promotion.Builder().setPromotionId(promotionsId).setName(name).setDescription(description)
                .setStartDate(startDate).setEndDate(endDate).setDiscountType(discountType)
                .setDiscountAmount(discountAmount).build();
    }
}
