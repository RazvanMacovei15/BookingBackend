package siemens.booking.services;

import siemens.booking.entity.Feedback;

import java.util.List;

public interface FeedbackService {
    Feedback save(Feedback feedback);
    List<Feedback> getFeedbacksByHotelId(Long hotelId);
    List<Feedback> getFeedbacksByUserId(Long userId);

}
