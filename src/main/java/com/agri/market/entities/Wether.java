package com.agri.market.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="wether")
@NoArgsConstructor
@Data
@Entity
public class Wether {
@Id
private int id;
}
