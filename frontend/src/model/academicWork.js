export default class AcademicWork {
    constructor(id, specialization, group, academicDiscipline, firstSemester, secondSemester, academicYear, incompleteReason, absoluteResults, qualityResults) {
        this.id = id;
        this.specialization = specialization;
        this.group = group;
        this.academicDiscipline = academicDiscipline;
        this.firstSemester = firstSemester;
        this.secondSemester = secondSemester;
        this.academicYear = academicYear;
        this.incompleteReason = incompleteReason;
        this.absoluteResults = absoluteResults;
        this.qualityResults = qualityResults;
    }
}