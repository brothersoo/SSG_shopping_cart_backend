package com.ssg.shoppingcart.domain.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.ssg.shoppingcart.domain.BaseTimeStampEntity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ssg_product")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Product extends BaseTimeStampEntity {

  @Id
  @Column(name = "ssg_product_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", unique = true, nullable = false)
  private String name;

  @Column(name = "price", nullable = false)
  private Integer price;

  @Column(name = "stock", nullable = false)
  private Integer stock;

  @ManyToOne(targetEntity = ProductGroup.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name = "ssg_product_group_id")
  @JsonBackReference
  private ProductGroup productGroup;

  @Builder
  public Product(Long id, String name, Integer price, Integer stock, ProductGroup productGroup) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.stock = stock;
    this.productGroup = productGroup;
  }

  public void addStock(Integer quantity) {
    this.stock += quantity;
  }

  public void subtractStock(Integer quantity) {
    this.stock -= quantity;
  }
}