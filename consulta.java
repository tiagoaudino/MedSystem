public class consulta {
    private String tipoConsulta;
    private double valorConsulta;
    private double horarioConsulta;
    private paciente paciente;


    public consulta(String tipoConsulta,double valorConsulta,double horarioConsulta,paciente paciente){
        this.tipoConsulta=tipoConsulta;
        this.valorConsulta=valorConsulta;
        this.horarioConsulta=horarioConsulta;
        this.paciente = paciente;

    }

    public void setTipoConsulta(String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public String getTipoConsulta() {
        return tipoConsulta;
    }

    public void setValorConsulta(double valorConsulta) {
        this.valorConsulta = valorConsulta;
    }

    public double getValorConsulta() {
        return valorConsulta;
    }

    public double gethorarioConsulta() {
        return horarioConsulta;
    }

    public paciente getPaciente() {

        return paciente;
    }
    public void setPaciente(paciente paciente){
        this.paciente=paciente;
    }

    public void sethorarioConsulta(double horarioConsulta) {
        this.horarioConsulta = horarioConsulta;
    }
}
