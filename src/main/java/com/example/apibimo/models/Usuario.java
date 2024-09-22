package com.example.apibimo.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.cglib.core.Local;

@Entity
@Table(name = "usuario")
@Schema(description = "Representa um usuário no sistema")
public class Usuario {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sid;

    @NotNull
    @Size(min = 2, message = "O nome deve ter no mínimo 2 caracteres")
    @Schema(description = "Nome do usuário")
    private String cnome;

    @NotNull
    @Size(min = 3, message = "O sobrenome deve ter mais que 3 caracteres")
    @Schema(description = "Sobrenome utilizado pelo usuário")
    private String csobrenome;

    @NotNull
    @Size(min = 4, message = "A senha deve conter pelo menos 4 caracteres.")
    @Schema(description = "Senha utilizada pelo usuário para logar.")
    private String csenha;

    @NotNull
    @Size(min = 11, message = "Um CPF deve conter no mínimo 11 caracteres.")
    @Schema(description = "CPF ligado à conta do usuário.")
    @CPF
    private String ccpf;

    @NotNull
    @Size(min = 7, message = "O email deve ter no mínimo 7 caracteres")
    @Schema(description = "E-mail ligado à conta do usuário")
    @Email
    private String cemail;

    @Size(min = 14, message = "O CNPJ deve ter no mínimo 14 caracteres.")
    @CNPJ
    @Schema(description = "Caso o usuário seja uma empresa, este campo guarda o CNPJ da empresa")
    private String ccnpj;

    @NotNull
    @Size(min = 11, message = "Um telefone deve ter no mínimo 11 caracteres.")
    @Schema(description = "Telefone de contato presente na conta do usuário")
    private String ctelefone;

    @NotNull
    @Schema(description = "Data de nascimento do usuário.")
    @Column(name = "ddatanascimento")
    private String ddatanascimento;

    @NotNull
    @Size(min = 8, message = "O link deve ter no mínimo 8 caracteres")
    @Schema(description = "Link do LinkedIn do usuário.")
    private String clinklinkedin;

    @NotNull
    @Schema(description = "Hash para login do usuário. Este hash vem do banco de dados.")
    private String cidhash;

    @NotNull
    @Schema(description = "Especialidade profissional do usuário")
    private String cespecialidadeprofissional;

    @Column(name = "transaction_made")
    @Schema(description = "Indica se uma transação foi feita")
    private boolean transaction_made;

    // Construtor com todos os atributos
    public Usuario(int sid, String cnome, String csobrenome, String csenha, String ccpf, String cemail, String ccnpj, String ctelefone, String ddatanascimento, String clinklinkedin, String cidhash, String cespecialidadeprofissional, boolean transaction_made) {
        this.sid = sid;
        this.cnome = cnome;
        this.csobrenome = csobrenome;
        this.csenha = csenha;
        this.ccpf = ccpf;
        this.cemail = cemail;
        this.ccnpj = ccnpj;
        this.ctelefone = ctelefone;
        this.ddatanascimento = ddatanascimento;
        this.clinklinkedin = clinklinkedin;
        this.cidhash = cidhash;
        this.cespecialidadeprofissional = cespecialidadeprofissional;
        this.transaction_made = transaction_made;
    }

    // Construtor vazio
    public Usuario() {
    }

    // Getters e Setters
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getCnome() {
        return cnome;
    }

    public void setCnome(String cnome) {
        this.cnome = cnome;
    }

    public String getCsobrenome() {
        return csobrenome;
    }

    public void setCsobrenome(String csobrenome) {
        this.csobrenome = csobrenome;
    }

    public String getCsenha() {
        return csenha;
    }

    public void setCsenha(String csenha) {
        this.csenha = csenha;
    }

    public String getCcpf() {
        return ccpf;
    }

    public void setCcpf(String ccpf) {
        this.ccpf = ccpf;
    }

    public String getCemail() {
        return cemail;
    }

    public void setCemail(String cemail) {
        this.cemail = cemail;
    }

    public String getCcnpj() {
        return ccnpj;
    }

    public void setCcnpj(String ccnpj) {
        this.ccnpj = ccnpj;
    }

    public String getCtelefone() {
        return ctelefone;
    }

    public void setCtelefone(String ctelefone) {
        this.ctelefone = ctelefone;
    }

    public String getDdatanascimento() {
        return String.valueOf(this.ddatanascimento);
    }

    public void setDdatanascimento(String ddatanascimento) {
        this.ddatanascimento = ddatanascimento;
     }

    public String getClinklinkedin() {
        return clinklinkedin;
    }

    public void setClinklinkedin(String clinklinkedin) {
        this.clinklinkedin = clinklinkedin;
    }

    public String getCidhash() {
        return cidhash;
    }

    public void setCidhash(String cidhash) {
        this.cidhash = cidhash;
    }

    public String getCespecialidadeprofissional() {
        return cespecialidadeprofissional;
    }

    public void setCespecialidadeprofissional(String cespecialidadeprofissional) {
        this.cespecialidadeprofissional = cespecialidadeprofissional;
    }

    public boolean isTransaction_made() {
        return transaction_made;
    }

    public void setTransaction_made(boolean transaction_made) {
        this.transaction_made = transaction_made;
    }

    @Override
    public String toString() {
        return "{" +
                "sid=" + sid +
                ", cnome='" + cnome + '\'' +
                ", csobrenome='" + csobrenome + '\'' +
                ", csenha='" + csenha + '\'' +
                ", ccpf='" + ccpf + '\'' +
                ", cemail='" + cemail + '\'' +
                ", ccnpj='" + ccnpj + '\'' +
                ", ctelefone='" + ctelefone + '\'' +
                ", ddatanascimento=" + ddatanascimento +
                ", clinklinkedin='" + clinklinkedin + '\'' +
                ", cidhash='" + cidhash + '\'' +
                ", cespecialidadeprofissional='" + cespecialidadeprofissional + '\'' +
                ", transaction_made=" + transaction_made +
                '}';
    }
}
