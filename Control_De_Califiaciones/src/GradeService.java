public class GradeService {

    public double calcPromedio(double a, double b, double c) {
        return (a + b + c) / 3;
    }

    public double calcPromFinal(double promedio, int asistencia) {
        return (promedio * 0.7) + (asistencia * 0.3);
    }

    public String estadoAprobReprob(double finalCal, int asistencia, boolean entregoProyecto) {
        if (asistencia < 80) {
            return "Reprobado por no asistir jaja";
        }
        if (!entregoProyecto) {
            return "Reprobado por no entregar el proyecto padrote ";
        }
        if (finalCal >= 70) {
            return "Aprobaste de panzaso ";
        } else {
            return "Reprobado por calif, ponte a estudiar.";
        }
    }
}
