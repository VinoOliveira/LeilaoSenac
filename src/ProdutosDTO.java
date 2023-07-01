/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
public class ProdutosDTO {
    private Integer id;
    private String nome;
    private Integer lanceInicial;
    private Integer lanceAtual;
    private Integer arremate;
    private String status;

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getLanceAtual() {
        return lanceAtual;
    }

    public Integer getLanceInicial() {
        return lanceInicial;
    }

    public Integer getArremate() {
        return arremate;
    }

    public String getStatus() {
        return status;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLanceInicial(Integer lanceInicial) {
        this.lanceInicial = lanceInicial;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public void setLanceAtual(Integer lanceAtual) {
        this.lanceAtual = lanceAtual;
    }
    public void setArremate(Integer arremate) {
        this.arremate = arremate;
    }
    
}
