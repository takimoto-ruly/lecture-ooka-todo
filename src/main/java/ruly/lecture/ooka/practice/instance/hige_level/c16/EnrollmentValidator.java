package ruly.lecture.ooka.practice.instance.hige_level.c16;

/**
 * 授業の受講資格を判定するクラスです。
 * 
 * <p>
 * 【利用クラス（DTO）の設計仕様】
 * </p>
 * <ul>
 * <li>StudentDTO: int grade, boolean hasPaidTuition</li>
 * <li>CourseDTO: int targetGrade, boolean isAdvanced</li>
 * <li>EnrollmentHistory: int completedCourses</li>
 * </ul>
 * 
 * <p>
 * 【判定ロジック仕様】
 * </p>
 * <ul>
 * <li>引数の student, course, history のいずれかが null の場合は false を返す。</li>
 * <li>学費(hasPaidTuition)が未納(false)の場合は false。</li>
 * <li>学生の学年(grade)が、コースの対象学年(targetGrade)未満の場合は false。</li>
 * <li>コースが上級(isAdvanced)の場合、修了済み数(completedCourses)が 5 未満なら false。</li>
 * <li>上記をすべて満たせば true。</li>
 * </ul>
 */
public class EnrollmentValidator {

}
