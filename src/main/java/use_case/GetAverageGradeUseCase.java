package use_case;
import api.GradeDB;
import entity.Grade;
import entity.Team;

import java.util.Arrays;

public final class GetAverageGradeUseCase {
    private final GradeDB gradeDB;

    public GetAverageGradeUseCase(GradeDB gradeDB) {
        this.gradeDB = gradeDB;
    }

    public float getAverageGrade(String course) {
        // TODO: Get average grade for all students in your team.
        Team team = gradeDB.getMyTeam();
        System.out.println(team);
        float sum = 0;
        for (String id: team.getMembers()) {
            sum += gradeDB.getGrade(id, course).getGrade();
        }

        return sum / team.getMembers().length;
    }
}
