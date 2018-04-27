package local.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class Chamado {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @NotNull(message="O comapo titulo não pode ser nulo")
    @Size(min=10, max=50)
    private String titulo;

    @NotNull(message="O campo descrição não pode ser nulo")
    @Size(min=20, max=120)
    private String descricao;

    @NotNull(message="Selecione um tipo")
    private String tipo;

    @NotNull
    private String status;

    @Email
    @NotNull(message="Informe um email para prosseguir")
    private String email;

    @Email
    private String email2;

    @Email
    private String email3;

    @NotNull(message="Informe um telefone para prosseguir")
    private String telefone;

    private String telefone2;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getEmail3() {
        return email3;
    }

    public void setEmail3(String email3) {
        this.email3 = email3;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chamado)) return false;
        Chamado chamado = (Chamado) o;
        return id == chamado.id &&
                Objects.equals(titulo, chamado.titulo) &&
                Objects.equals(descricao, chamado.descricao) &&
                Objects.equals(tipo, chamado.tipo) &&
                Objects.equals(status, chamado.status) &&
                Objects.equals(email, chamado.email) &&
                Objects.equals(email2, chamado.email2) &&
                Objects.equals(email3, chamado.email3) &&
                Objects.equals(telefone, chamado.telefone) &&
                Objects.equals(telefone2, chamado.telefone2);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, titulo, descricao, tipo, status, email, email2, email3, telefone, telefone2);
    }
}
