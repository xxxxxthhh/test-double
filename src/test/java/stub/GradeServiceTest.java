package stub;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.xml.transform.Result;
import java.util.Arrays;
import java.util.List;

public class GradeServiceTest {
    /* 需求描述：
    编写GradeService类的单元测试，单元测试calculateAverageGrades方法
    * */
    private class mockGradeService extends GradeService{

        public mockGradeService(GradeSystem gradeSystem) {
            super(gradeSystem);
        }

        @Override
        public double calculateAverageGrades(long studentId) {
            List<Double> doubles = Arrays.asList(80.0, 90.0, 100.0);

            double averageGrade = doubles.stream()
                    .mapToDouble((grade) -> grade)
                    .average()
                    .orElse(0);

            return averageGrade;
        }
    }

    @Test
    public void shouldReturn90WhenCalculateStudentAverageGradeAndGradeIs80And90And100() {
        GradeSystem gradeSystem = new GradeSystem();
        GradeService gradeService = new mockGradeService(gradeSystem);

        Assertions.assertEquals(90.0, gradeService.calculateAverageGrades(1));
    }
}
