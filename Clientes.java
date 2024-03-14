package trabdb4o;

public class Clientes {
    private String nome, cpf, gmail, senha;
    private int id;
    
    // GET e SET id
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    // GET e SET nome
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    // GET e SET cpf
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // GET e SET gmail
    public String getGmail() {
        return gmail;
    }
    public void setGmail(String gmail) {
        this.gmail = gmail;
    }
    
    // GET e SET senha
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
}//public class Clientes
