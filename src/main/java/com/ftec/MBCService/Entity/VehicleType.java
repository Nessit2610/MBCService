package com.ftec.MBCService.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="vehicle_types")
public class VehicleType {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="name")
	private String name;
	@OneToMany(mappedBy = "vehicleType",cascade = CascadeType.ALL)
	private List<Vehicle> vehicles;
}
