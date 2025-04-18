package com.SpringBootJdk22.SpringBootJdk22.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID của booking

    @ManyToOne
    @JoinColumn(name = "tour_id", nullable = false)
    private Tour tour; // Tour được đặt

    @Column(nullable = false)
    private LocalDate startDate; // Ngày bắt đầu lịch trình (lưu trực tiếp)

    @Column(nullable = false)
    private LocalDate endDate; // Ngày kết thúc lịch trình (lưu trực tiếp)

    @Column(nullable = false,columnDefinition = "TEXT CHARACTER SET utf8 COLLATE utf8_general_ci")
    private String fullName; // Họ và tên của người đặt

    @Column(nullable = false)
    private String email; // Email người đặt

    @Column(nullable = false)
    private String phoneNumber; // Số điện thoại người đặt

    @Column(name = "booking_date", nullable = false)
    private LocalDate bookingDate; // Ngày đặt (tự động)

    @Column(name = "number_of_people", nullable = false)
    private int numberOfPeople; // Số lượng người tham gia

    private boolean status = false; // Trạng thái đặt chỗ

    @PrePersist
    public void prePersist() {
        this.bookingDate = LocalDate.now(); // Gán ngày đăng ký hiện tại khi lưu vào DB
    }
}
