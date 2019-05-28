package unq.tpi.desapp.request;

import com.sun.istack.NotNull;
import unq.tpi.desapp.model.Product;

import java.util.Date;
import java.util.List;

public class EventRequest {

    @NotNull
    String type;
    @NotNull
    String name;

    String description;
    @NotNull
    List<Product> products;
    @NotNull
    List<Long> userIds;
    @NotNull
    Long ownerId;
    @NotNull
    Date deadline;
    @NotNull
    Date heldAt;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Long> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Long> userIds) {
        this.userIds = userIds;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getHeldAt() {
        return heldAt;
    }

    public void setHeldAt(Date heldAt) {
        this.heldAt = heldAt;
    }
}
