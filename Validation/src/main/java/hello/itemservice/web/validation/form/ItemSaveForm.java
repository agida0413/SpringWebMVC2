package hello.itemservice.web.validation.form;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ItemSaveForm {

    @NotBlank
    private String itemName;

    @NotNull
    @Range(min = 1000, max = 1000000)
    private Integer price;

    public @NotBlank String getItemName() {
        return itemName;
    }

    public void setItemName(@NotBlank String itemName) {
        this.itemName = itemName;
    }

    public @NotNull @Max(value = 9999) Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(@NotNull @Max(value = 9999) Integer quantity) {
        this.quantity = quantity;
    }

    public @NotNull @Range(min = 1000, max = 1000000) Integer getPrice() {
        return price;
    }

    public void setPrice(@NotNull @Range(min = 1000, max = 1000000) Integer price) {
        this.price = price;
    }

    @NotNull
    @Max(value = 9999)
    private Integer quantity;
}
