package com.ftec.MBCService.Entity;

import java.sql.Blob;
import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name="vehicles")
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name; //Tên xe
	@Column(name="vehicle_style")
	private String vehicleStyle; // Kiểu xe
	@Column(name="brand")
	private String brand; //Thương hiệu
	@Column(name="modal")
	private String modal; //Mẫu xe
	@Column(name="capacity")
	private int capacity; //Số chỗ ngồi
	@Column(name="registration_date")
	private Date registrationDate; //Ngày đăng ký
	@Column(name="cylinder")
	private Double cylinder;//Dung tích xi lanh
	@Column(name="image")
	private Blob image;// ảnh xe
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "vehicle_type_id")
	private VehicleType vehicleType;// Id loại xe
}
