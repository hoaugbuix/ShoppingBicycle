package com.hoangbuix.bicycle.model.request.update;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdatePromotionReq {
    //    @NotNull(message = "Brand Name trống")
//    @NotEmpty(message = "Brand Name trống")
//    @Email(message = "Brand Name không đúng định dạng")
//    @ApiModelProperty(
//            example = "Brand Name",
//            notes = "Brand Name trống",
//            required = true
//    )
    private String name;

    private String couponCode;

    private String discountType;

    private int discountValue;

    private int maximumDiscountValue;

    private int isActive;

    private int isPublic;

    private int activeFlag;
}
