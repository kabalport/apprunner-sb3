package com.kabalport.apprunnersb3.score.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SaveExamScoreRequest {
  private final String studentName;
  private final Integer korScore;
  private final Integer englishScore;
  private final Integer mathScore;
}
