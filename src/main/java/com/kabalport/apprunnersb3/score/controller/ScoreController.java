package com.kabalport.apprunnersb3.score.controller;


import com.kabalport.apprunnersb3.score.dto.request.SaveExamScoreRequest;
import com.kabalport.apprunnersb3.score.dto.response.ExamFailStudentResponse;
import com.kabalport.apprunnersb3.score.dto.response.ExamPassStudentResponse;
import com.kabalport.apprunnersb3.score.service.StudentScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RequiredArgsConstructor
@RestController
public class ScoreController {

  private final StudentScoreService studentScoreService;

  @PutMapping("/exam/{exam}/score")
  public void save(@PathVariable("exam") String exam, @RequestBody SaveExamScoreRequest request) {

    System.out.println(request.getStudentName());
    System.out.println(request.getKorScore());
    System.out.println(request.getEnglishScore());
    System.out.println(request.getMathScore());
    System.out.println(exam);
    studentScoreService.saveScore(
        request.getStudentName(),
        exam,
        request.getKorScore(),
        request.getEnglishScore(),
        request.getMathScore());
  }

  @GetMapping("/exam/{exam}/pass")
  public List<ExamPassStudentResponse> pass(@PathVariable("exam") String exam) {
    return studentScoreService.getPassStudentList(exam);
  }

  @GetMapping("/exam/{exam}/fail")
  public List<ExamFailStudentResponse> fail(@PathVariable("exam") String exam) {
    return studentScoreService.getFailStudentList(exam);
  }
}
