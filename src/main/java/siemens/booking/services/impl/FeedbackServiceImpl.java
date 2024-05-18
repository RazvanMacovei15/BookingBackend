package siemens.booking.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import siemens.booking.entity.Feedback;
import siemens.booking.repository.FeedbackRepository;
import siemens.booking.services.FeedbackService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {
    private final FeedbackRepository feedbackRepository;

    @Override
    public Feedback save(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    @Override
    public List<Feedback> getFeedbacksByHotelId(Long hotelId) {
        return null;
    }

    @Override
    public List<Feedback> getFeedbacksByUserId(Long userId) {
        return null;
    }
}
