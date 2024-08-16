//package com.ftec.MBCService.Entity;
//
//import jakarta.persistence.*;
//@Entity
//@Table(name="bookings")
//public class Booking {
//	@Id
//	@Column(name="booking_id")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private String bookingID; //ID của đơn đặt xe.
//	
//	
//	
//	@Column(name="customer_id")
//	private String customerID; //(Foreign Key): Liên kết với bảng Customer.
//	@Column(name="vehicle_id")
//	private String vehicleID; //(Foreign Key): Liên kết với bảng Vehicle.
//	
//	
//	
//	@Column(name="start_location")
//	private String startLocation; //Địa điểm bắt đầu.
//	@Column(name="end_location")
//	private String endLocation; //Địa điểm kết thúc.
//	@Column(name="booking_time")
//	private String bookingTime; //Thời gian đặt xe.
//	@Column(name="status")
//	private String status; //Trạng thái của đơn đặt xe (Đang chờ, Đã hoàn thành, Đã hủy).
//}
