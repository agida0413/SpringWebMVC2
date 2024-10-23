package hello.itemservice.web.validation.form;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ItemUpdateForm {

    @NotNull
    private Long id;

    @NotBlank
    private String itemName;

    @NotNull
    @Range(min = 1000, max = 1000000)
    private Integer price;

    public @NotNull Long getId() {
        return id;
    }

    public void setId(@NotNull Long id) {
        this.id = id;
    }

    public @NotBlank String getItemName() {
        return itemName;
    }

    public void setItemName(@NotBlank String itemName) {
        this.itemName = itemName;
    }

    public @NotNull @Range(min = 1000, max = 1000000) Integer getPrice() {
        return price;
    }

    public void setPrice(@NotNull @Range(min = 1000, max = 1000000) Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    //수정에서는 수량은 자유롭게 변경할 수 있다.
    private Integer quantity;
}
