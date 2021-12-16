package com.hoangbuix.bicycle.model.request.update;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateOrderReq {
    //    @NotNull(message = "Brand Name trống")
//    @NotEmpty(message = "Brand Name trống")
//    @Email(message = "Brand Name không đúng định dạng")
//    @ApiModelProperty(
//            example = "Brand Name",
//            notes = "Brand Name trống",
//            required = true
//    )
    private String note;
    private int productPrice;
    private int promotionId;
    private int productId;
    private int productSize;
    private String receiverName;
    private String receiverAddress;
    private String receiverPhone;
    private int status;
    private int totalPrice;
    private int buyer;
    private int createdBy;
    private int modifiedBy;
    private int activeFlag;
}
