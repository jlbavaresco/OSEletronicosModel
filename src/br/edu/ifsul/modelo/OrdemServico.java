package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
@Entity
@Table(name = "ordem_servico")
public class OrdemServico implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_ordem_servico", sequenceName = "seq_ordem_servico_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_ordem_servico", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "A data de abertura não pode ser nula")
    @Temporal(TemporalType.DATE)
    @Column(name = "data_abertura", nullable = false)
    private Calendar dataAbertura;
    @Temporal(TemporalType.DATE)
    @Column(name = "data_fechamento", nullable = false)
    private Calendar dataFechamento;
    @NotNull(message = "A descrição do problema não pode ser nula")
    @NotBlank(message = "A descrição do problema não pode ser em branco")
    @Column(name = "descricao_problema", columnDefinition = "text", nullable = false)
    private String descricaoProblema;
    @Column(name = "resolucao_problema", columnDefinition = "text")
    private String resolucaoProblema;
    @Min(message = "O valor dos produtos não pode ser negativo", value = 0)
    @NotNull(message = "O valor dos produtos deve ser informado")
    @Column(name = "valor_produtos", nullable = false, columnDefinition = "numeric(12,2)")
    private Double valorProdutos;
    @Min(message = "O valor dos serviços não pode ser negativo", value = 0)
    @NotNull(message = "O valor dos serviços deve ser informado")
    @Column(name = "valor_servicos", nullable = false, columnDefinition = "numeric(12,2)")
    private Double valorServicos;
    @Min(message = "O valor total não pode ser negativo", value = 0)
    @NotNull(message = "O valor total deve ser informado")
    @Column(name = "valor_total", nullable = false, columnDefinition = "numeric(12,2)")
    private Double valorTotal;
    @NotNull(message = "O status deve ser informado")
    @Column(name = "status", nullable = false, length = 15)
    @Enumerated(EnumType.STRING)
    private Status status;
    @NotNull(message = "A forma de pagamento deve ser informada")
    @Column(name = "forma_pagamento", nullable = false, length = 6)
    @Enumerated(EnumType.STRING)
    private FormaPagamento formaPagamento;
    @NotNull(message = "A quantidade de parcelas deve ser informada")
    @Min(message = "O valor dos produtos não pode ser negativo", value = 0)
    @Column(name = "quantidade_parcelas", nullable = false)
    private Integer quantidadeParcelas;
    @NotNull(message = "A pessoa física deve ser informada")
    @ManyToOne
    @JoinColumn(name = "pessoa_fisica", referencedColumnName = "nome_usuario", nullable = false,
            foreignKey = @ForeignKey(name = "fk_ordem_servico_pf"))    
    private PessoaFisica pesssoaFisica;
    @NotNull(message = "O usuário deve ser informado")
    @ManyToOne
    @JoinColumn(name = "usuario", referencedColumnName = "nome_usuario", nullable = false,
            foreignKey = @ForeignKey(name = "fk_ordem_servico_usuario"))    
    private Usuario usuario;
    @NotNull(message = "O equipamento deve ser informado")
    @ManyToOne
    @JoinColumn(name = "equipamento", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_ordem_servico_equipamento"))      
    private Equipamento equipamento;

    public OrdemServico() {
        valorProdutos = 0.0;
        valorServicos = 0.0;
        valorTotal = 0.0;
        quantidadeParcelas = 0;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Calendar dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Calendar getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Calendar dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public String getDescricaoProblema() {
        return descricaoProblema;
    }

    public void setDescricaoProblema(String descricaoProblema) {
        this.descricaoProblema = descricaoProblema;
    }

    public String getResolucaoProblema() {
        return resolucaoProblema;
    }

    public void setResolucaoProblema(String resolucaoProblema) {
        this.resolucaoProblema = resolucaoProblema;
    }

    public Double getValorProdutos() {
        return valorProdutos;
    }

    public void setValorProdutos(Double valorProdutos) {
        this.valorProdutos = valorProdutos;
    }

    public Double getValorServicos() {
        return valorServicos;
    }

    public void setValorServicos(Double valorServicos) {
        this.valorServicos = valorServicos;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Integer getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public void setQuantidadeParcelas(Integer quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    public PessoaFisica getPesssoaFisica() {
        return pesssoaFisica;
    }

    public void setPesssoaFisica(PessoaFisica pesssoaFisica) {
        this.pesssoaFisica = pesssoaFisica;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }
}
