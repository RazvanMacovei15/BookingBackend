package siemens.booking.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import siemens.booking.dto.FeedbackDto;
import siemens.booking.entity.Feedback;
import siemens.booking.mappers.Mapper;
@Component
public class FeedbackMapper implements Mapper<Feedback, FeedbackDto> {
    private ModelMapper modelMapper;

    public FeedbackMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public FeedbackDto mapTo(Feedback feedback) {
       return modelMapper.map(feedback, FeedbackDto.class);
    }

    @Override
    public Feedback mapFrom(FeedbackDto feedbackDto) {
        return modelMapper.map(feedbackDto, Feedback.class);
    }
}
