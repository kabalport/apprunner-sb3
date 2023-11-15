package com.kabalport.apprunnersb3.review.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateReviewRequest {
    private final Long restaurantId;
    private final String content;
    private final Double score;
}
