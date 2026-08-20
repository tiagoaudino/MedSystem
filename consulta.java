public class consulta {
    private String tipoConsulta;
    private double valorConsulta;
    private String horarioConsulta;
    private paciente paciente;
    private String dataConsulta;


    public consulta(String tipoConsulta,double valorConsulta,String horarioConsulta,String dataConsulta,paciente paciente){
        this.tipoConsulta=tipoConsulta;
        this.valorConsulta=valorConsulta;
        this.horarioConsulta=horarioConsulta;
        this.paciente = paciente;
        this.dataConsulta=dataConsulta;

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

    public String gethorarioConsulta() {
        return horarioConsulta;
    }

    public void sethorarioConsulta(String horarioConsulta) {
        this.horarioConsulta = horarioConsulta;
    }

    public paciente getPaciente() {return paciente;}

    public void setPaciente(paciente paciente){this.paciente=paciente;}

    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getDataConsulta() {
        return dataConsulta;
    }
}
