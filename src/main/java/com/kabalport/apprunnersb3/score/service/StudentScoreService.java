package com.kabalport.apprunnersb3.score.service;


import com.kabalport.apprunnersb3.calcaulator.MyCalculator;
import com.kabalport.apprunnersb3.score.dto.response.ExamFailStudentResponse;
import com.kabalport.apprunnersb3.score.dto.response.ExamPassStudentResponse;
import com.kabalport.apprunnersb3.score.model.StudentFail;
import com.kabalport.apprunnersb3.score.model.StudentPass;
import com.kabalport.apprunnersb3.score.model.StudentScore;
import com.kabalport.apprunnersb3.score.repository.StudentFailRepository;
import com.kabalport.apprunnersb3.score.repository.StudentPassRepository;
import com.kabalport.apprunnersb3.score.repository.StudentScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentScoreService {
  private final StudentScoreRepository studentScoreRepository;
  private final StudentPassRepository studentPassRepository;
  private final StudentFailRepository studentFailRepository;

  public void saveScore(
      String studentName, String exam, Integer korScore, Integer englishScore, Integer mathScore) {
    StudentScore studentScore =
        StudentScore.builder()
            .exam(exam)
            .studentName(studentName)
            .korScore(korScore)
            .englishScore(englishScore)
            .mathScore(mathScore)
            .build();

    System.out.println(korScore);
    studentScoreRepository.save(studentScore);

    MyCalculator myCalculator = new MyCalculator(0.0);
    Double avgScore =
        myCalculator
            .add(korScore.doubleValue())
            .add(englishScore.doubleValue())
            .add(mathScore.doubleValue())
            .divide(3.0)
            .getResult();
    if (avgScore >= 60) {
      StudentPass studentPass =
          StudentPass.builder().exam(exam).studentName(studentName).avgScore(avgScore).build();
      studentPassRepository.save(studentPass);
    } else {
      StudentFail studentFail =
          StudentFail.builder().exam(exam).studentName(studentName).avgScore(avgScore).build();
      studentFailRepository.save(studentFail);
    }
  }

  public List<ExamPassStudentResponse> getPassStudentList(String exam) {
    List<StudentPass> studentPasses = studentPassRepository.findAll();

    return studentPasses.stream()
        .filter((pass) -> pass.getExam().equals(exam))
        .map((pass) -> new ExamPassStudentResponse(pass.getStudentName(), pass.getAvgScore()))
        .toList();
  }

  public List<ExamFailStudentResponse> getFailStudentList(String exam) {
    List<StudentFail> studentFails = studentFailRepository.findAll();

    return studentFails.stream()
        .filter((pass) -> pass.getExam().equals(exam))
        .map((pass) -> new ExamFailStudentResponse(pass.getStudentName(), pass.getAvgScore()))
        .toList();
  }
}
