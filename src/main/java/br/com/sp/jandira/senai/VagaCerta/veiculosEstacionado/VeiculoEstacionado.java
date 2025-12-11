package br.com.sp.jandira.senai.VagaCerta.veiculosEstacionado;

public class VeiculoEstacionado {

    private String id;
    private String nome;
    private String modelo;
    private String placa;
    private String cor;
    private String totalPagar;

    public VeiculoEstacionado(String id, String nome, String modelo, String placa, String cor, String totalPagar){
        this.id = id;
        this.nome = nome;
        this.modelo = modelo;
        this.placa = placa;
        this.cor = cor;
        this.totalPagar = totalPagar;
    }

    public String getId() { return id; }
    public String getNome() { return nome; }
    public String getModelo() { return modelo; }
    public String getPlaca() { return placa; }
    public String getCor() { return cor; }
    public String getTotalPagar() { return totalPagar; }

    public void setId(String id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public void setPlaca(String placa) { this.placa = placa; }
    public void setCor(String cor) { this.cor = cor; }
    public void setTotalPagar(String totalPagar) { this.totalPagar = totalPagar; }
}
