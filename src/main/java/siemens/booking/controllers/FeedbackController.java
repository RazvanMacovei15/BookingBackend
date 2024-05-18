package siemens.booking.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import siemens.booking.dto.FeedbackDto;
import siemens.booking.entity.Feedback;
import siemens.booking.mappers.Mapper;
import siemens.booking.services.FeedbackService;

@RestController
@RequestMapping("/feedbacks")
@AllArgsConstructor
public class FeedbackController {
    private final FeedbackService feedbackService;


    private Mapper<Feedback, FeedbackDto> feedbackMapper;

    @PostMapping
    public FeedbackDto createFeedback(FeedbackDto feedbackDto){
        Feedback feedback = feedbackMapper.mapFrom(feedbackDto);
        Feedback savedFeedback = feedbackService.save(feedback);
        return feedbackMapper.mapTo(savedFeedback);
    }
}
